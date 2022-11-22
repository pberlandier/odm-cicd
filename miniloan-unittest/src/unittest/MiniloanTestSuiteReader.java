package unittest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.ibm.rules.cdi.core.Scenario;
import com.ibm.rules.cdi.core.Test;

import miniloan.Borrower;
import miniloan.Loan;


public class MiniloanTestSuiteReader extends AbstractItemReader {

    private int currentItem;

    @Inject
    @BatchProperty(name = "dataset.name")
    String dataSetName;

    private String[] fieldNames;
    private List<String[]> testData;
    
    static { trustConnection(); }
    
    public static void trustConnection(){
    	X509TrustManager x509 = new X509TrustManager(){
			public X509Certificate[] getAcceptedIssuers(){return null;}
			public void checkClientTrusted(X509Certificate[] certs, String authType){}
			public void checkServerTrusted(X509Certificate[] certs, String authType){}
		};
    	
        TrustManager[] trustAllCerts = new TrustManager[]{x509};
        		
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
    }

    @Override
    public void open(java.io.Serializable checkpoint) throws Exception {
    	//
    	// dataSetName is mandatory.
    	//
    	String resourceName =  dataSetName; 
    	
    	InputStream in;
    	URL resourceURL = new URL(resourceName);
    	String protocol = resourceURL.getProtocol();
    	if ( protocol.equals("file") ) {
    		in = new FileInputStream(resourceURL.getFile());
    	}
    	else if ( protocol.equals("http") ) {
    		HttpURLConnection connection = (HttpURLConnection) resourceURL.openConnection();
    		in = connection.getInputStream();
    	}
    	else if ( protocol.equals("https") ) {
    		HttpsURLConnection connection = (HttpsURLConnection) resourceURL.openConnection();
    		in = connection.getInputStream();
    	}
    	else {
    		throw new Exception("Unexpected unit test scenario file URL: " + resourceName);
    	}
    	
        if (in != null) {
            testData = new ArrayList<String[]>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            for(String line; (line = reader.readLine()) != null; ) {
            	System.out.println("Reading " + line);
                String[] tokens = line.split(",");
                 if (fieldNames == null) {
                    fieldNames = tokens;
                } else {
                    testData.add(tokens);
                }
            }
            reader.close();
        } 
    }
    
    private static final int SC_NAME = 0;
    private static final int SC_DESC = 1;

    private static final int B_NAME = 2;
    private static final int B_SCORE = 3;
    private static final int B_INCOME = 4;
    
    private static final int L_AMOUNT = 5;
    private static final int L_DURATION = 6;
    private static final int L_INTEREST = 7;
    
    private static final int R_APPROVED = 8;

    @Override
    public Object readItem() throws Exception {
        if (this.testData == null || this.currentItem >= this.testData.size()) {
            return null;
        }

        String[] fields = this.testData.get(this.currentItem);

        Borrower borrower = new Borrower();
		borrower.setName(fields[B_NAME]);
		System.out.println(borrower.getName());
		borrower.setCreditScore(Integer.parseInt(fields[B_SCORE]));
		borrower.setYearlyIncome(Integer.parseInt(fields[B_INCOME]));
		
		Loan loan = new Loan();
		loan.setAmount(Integer.parseInt(fields[L_AMOUNT]));
		loan.setDuration(Integer.parseInt(fields[L_DURATION]));
		loan.setYearlyInterestRate(Double.parseDouble(fields[L_INTEREST]));

        Scenario scenario = new Scenario();
        scenario.setName(!fields[SC_NAME].isEmpty() ? fields[SC_NAME] : "Scenario #" + String.format("%02d", currentItem + 1));
        if (!fields[SC_DESC].isEmpty()) {
            scenario.setDescription(fields[SC_DESC]);
        }

        scenario.addInputParameter("borrower", borrower);
        scenario.addInputParameter("loan", loan);

        if (!fields[R_APPROVED].isEmpty()) {
        	Test test = new Test();
        	test.setId("Approved");
        	test.setExpectedValues(new Object[]{Boolean.parseBoolean(fields[R_APPROVED])});
        	scenario.addTest(test);
        }

        this.currentItem++;
        return scenario;
    }
}

