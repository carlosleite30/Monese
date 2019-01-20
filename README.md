# Monese
INSTRUCTIONS TO PC:

To run for the first time the project in cmd line follow the next steps:
1) Open command promp
2) Go to directory of the project
3) Write "mvn compile" to compile the project and get all dependencies
4) Write "mvn test" to run the tests

IF YOU GET THE ERROR "RECEIVED FATAL ALERT: PROTOCOL_VERSION" OR "PEER NOT AUTHENTICATED" PLEASE FOLLOW THIS STEPS:
1) Open command promp
2) Go to directory of the project
3) Write "mvn -Dhttps.protocols=TLSv1.2 install" and all dependencies will be download.
4) Write "mvn test" to run the tests

After run for the first time you can run again the test. 
For that write only "mvn test"
