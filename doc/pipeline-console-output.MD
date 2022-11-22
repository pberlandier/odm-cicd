# Jenkins console output

## Pipeline Starts
```
Started by user admin
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in C:\Users\jenkins\AppData\Local\Jenkins\.jenkins\workspace\build-miniloan
[Pipeline] {
```
## Initialize
```
[Pipeline] stage
[Pipeline] { (Initialize)
[Pipeline] echo
Initializing...
[Pipeline] script
[Pipeline] {
[Pipeline] bat
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
100   213    0   213    0     0   3509      0 --:--:-- --:--:-- --:--:--  3610
[Pipeline] echo
Retrieved decision service id: f7930131-00c9-4016-af89-ebdae653086d
[Pipeline] bat
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
100   369    0   369    0     0  18228      0 --:--:-- --:--:-- --:--:-- 19421
[Pipeline] echo
Retrieved release id: d4b1fb4f-2d86-41ec-bfe5-210acd8bcd26
[Pipeline] }
[Pipeline] // script
[Pipeline] }
[Pipeline] // stage
```
## Unit Testing
```
[Pipeline] stage
[Pipeline] { (Unit Testing)
[Pipeline] echo
Running unit tests...
[Pipeline] script
[Pipeline] {
[Pipeline] bat
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
100   105    0     0  100   105      0    523 --:--:-- --:--:-- --:--:--   525
100   460    0   355  100   105   1651    488 --:--:-- --:--:-- --:--:--  2139
[Pipeline] echo
Running command @curl -X GET -u "rtsAdmin:rtsAdmin" "http://localhost:9090/decisioncenter-api/v1/decisionservices/f7930131-00c9-4016-af89-ebdae653086d/testsuites?baselineId=23678748-3e4b-4fd6-a07f-0573d98d25fe&q=name:test-suite" -H "accept: application/json"
[Pipeline] bat
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
100   157    0   157    0     0   4756      0 --:--:-- --:--:-- --:--:--  4906
[Pipeline] bat
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
100   224    0   224    0     0   1161      0 --:--:-- --:--:-- --:--:--  1166
[Pipeline] readJSON
[Pipeline] retry
[Pipeline] {
[Pipeline] sleep
Sleeping for 10 sec
[Pipeline] bat
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
100   224    0   224    0     0   9177      0 --:--:-- --:--:-- --:--:--  9739
[Pipeline] readJSON
[Pipeline] }
[Pipeline] // retry
[Pipeline] bat
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
[Pipeline] }
[Pipeline] // script
[Pipeline] }
[Pipeline] // stage
```
## Auto Review
```
[Pipeline] stage
[Pipeline] { (Auto-review)
[Pipeline] echo
Auto-reviewing project rules...
[Pipeline] script
[Pipeline] {
[Pipeline] bat

C:\Users\jenkins\AppData\Local\Jenkins\.jenkins\workspace\build-miniloan>C:/MyProgramFiles/ant/bin/ant -f C:/odm-cicd/ota/ota.xml run-ota -Dota.report=C:/odm-cicd/ota/output/jenkins-build-miniloan-3 -Dota.projects=miniloan-rules/v-next 
Buildfile: C:\odm-cicd\ota\ota.xml

run-ota:
     [java] Sep 21, 2022 3:06:59 PM com.ibm.odm.ota.ProjectSelections getSelectedItems
     [java] INFO: @ Processing project list
     [java] Sep 21, 2022 3:07:00 PM com.ibm.odm.ota.OTARunner run
     [java] INFO: Starting repository analysis for http://localhost:9090/decisioncenter
     [java] Sep 21, 2022 3:07:00 PM com.ibm.odm.ota.Findings load
     [java] INFO: Loading findings configuration file file:/C:/odm-cicd/ota/resources/findings.xlsx
     [java] Sep 21, 2022 3:07:00 PM com.ibm.odm.ota.checker.ProjectChecker run
     [java] INFO: @ Checking individual rule projects from repository
     [java] Sep 21, 2022 3:07:00 PM com.ibm.odm.ota.checker.ProjectChecker runOne
     [java] INFO: Checking project miniloan-rules in branch v-next
     [java] Cleaning up unclosed ZipFile for archive C:\odm-cicd\ota\resources\findings.xlsx
     [java] Sep 21, 2022 3:07:01 PM com.ibm.odm.ota.checker.BOMChecker run
     [java] INFO: @ Checking BOM projects from repository
     [java] Sep 21, 2022 3:07:01 PM com.ibm.odm.ota.checker.BOMChecker checkBOM
     [java] INFO: Checking miniloan BOM from project miniloan-rules
     [java] Sep 21, 2022 3:07:01 PM com.ibm.odm.ota.checker.BOMChecker checkB2X
     [java] INFO: Checking miniloan B2X from project miniloan-rules
     [java] Sep 21, 2022 3:07:01 PM com.ibm.odm.ota.checker.BOMChecker checkVoc
     [java] INFO: Checking miniloan vocabulary from project miniloan-rules
     [java] Sep 21, 2022 3:07:01 PM com.ibm.odm.ota.OTARunner run
     [java] INFO: Analysis completed, results available in C:/odm-cicd/ota/output/jenkins-build-miniloan-3
     [java] Sep 21, 2022 3:07:01 PM com.ibm.odm.ota.DCConnection endSession
     [java] INFO: Ending use of DC session

BUILD SUCCESSFUL
Total time: 4 seconds
[Pipeline] readJSON
[Pipeline] echo
Auto-review results are available in file C:/odm-cicd/ota/output/jenkins-build-miniloan-3.html
[Pipeline] }
[Pipeline] // script
[Pipeline] }
[Pipeline] // stage
```
## Manual Review
```
[Pipeline] stage
[Pipeline] { (Manual Review)
[Pipeline] echo
Start manual review...
[Pipeline] script
[Pipeline] {
[Pipeline] registerWebhook
[Pipeline] echo
Registered Jenkins webhook to http://localhost:8080/webhook-step/miniloan-rules_v-next_jenkins-build-miniloan-3
[Pipeline] bat
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
100   152    0   152    0     0   6303      0 --:--:-- --:--:-- --:--:--  6608
[Pipeline] echo
Created DC webhook 477219dd-f199-4c6a-86d5-d1603d3987fd
[Pipeline] bat
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
100   558    0   422  100   136   3492   1125 --:--:-- --:--:-- --:--:--  4650
[Pipeline] echo
Created validation activity named manualreview_jenkins-build-miniloan-3 with id c0132751-c964-4aef-afb8-4287cefa21cb
[Pipeline] waitForWebhook
[Pipeline] bat
[Pipeline] echo
Update value NotReviewed
[Pipeline] waitForWebhook
[Pipeline] bat
[Pipeline] echo
Update value ApprovedChanges
[Pipeline] echo
@curl -X DELETE -u "rtsAdmin:rtsAdmin" http://localhost:9090/decisioncenter-api/v1/webhooks/477219dd-f199-4c6a-86d5-d1603d3987fd/notify -H "accept: */*"
[Pipeline] bat
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
[Pipeline] echo
Deleted DC webhook 477219dd-f199-4c6a-86d5-d1603d3987fd
[Pipeline] echo
Manual review completed
[Pipeline] }
[Pipeline] // script
[Pipeline] }
[Pipeline] // stage
```
## Deploy
```
[Pipeline] stage
[Pipeline] { (Deploy)
[Pipeline] echo
Deploying to RES...
[Pipeline] script
[Pipeline] {
[Pipeline] bat
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
100   261    0   261    0     0   5107      0 --:--:-- --:--:-- --:--:--  5220
[Pipeline] bat
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
100   894    0   894    0     0    748      0 --:--:--  0:00:01 --:--:--   749
100   894    0   894    0     0    746      0 --:--:--  0:00:01 --:--:--   747
[Pipeline] readJSON
[Pipeline] }
[Pipeline] // script
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
```
## Pipeline Ends
```
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
```

