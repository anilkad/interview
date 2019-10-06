gatling-maven-plugin-demo
=========================

Simple showcase of a maven project using the gatling-maven-plugin.

To test it out, simply execute the following command:

    $mvn gatling:test -Dgatling.simulationClass=computerdatabase.BasicSimulation

or simply:

    $mvn gatling:test


Updated to add a test for Crypto Homework

to run the test use - "mvn gatling:test"
the test is configured to run against the decide service running on port 8080 of localhost

by default, it runs with 5 users in 30 seconds. can be changed using -
mvn gatling:test -Dusers=$users -DdurationInSecs=$duration

 
Assertions - 
Currently, the test has 2 assertions - 
1. response code = 200
2. response body to contain "BTC" or "ETH"

At this time, it does not have any assertion on response time

Reports can be found in target directory at the end of test run

Time taken for the homework - close to 2 hours. I tried to get gradle to work with gatling but
was running into errors so I switched to maven with which I am familiar.