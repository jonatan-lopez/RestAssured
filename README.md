# TestRestAPI Project 
---------------------------------
#How to Build
You only need the following tools:

Gradle : https://gradle.org/install

Java: https://java.com/en/download


For build the project you can run the following command:

gradle build -x test

----------------------------------
#Run the tests

You only need to run the command

./gradlew build test -Denv= < environment properties >

example: gradle build test -Denv=env

------------------------------------

#Generate Reports

The Framework have allure reports.For generate this you need
to run the following command:

For generate the reports: 

gradle allureReport

For Serve the reports:

gradle allureServe 
