# Usage

## Pre-requisites
* Java
* Docker

## Build
>./gradlew build docker

## Run App
>docker run -p 8080:8080 interview/crypto  

See the service working by  
>curl http://localhost:8080/decide

### pact
##### Run Tests 
>./gradlew clean test 

##### Publish contracts to pact broker
>./gradlew pactPublish

##### Verify provider against contracts
>./gradlew pactVerify

