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

## Run Tests 
running pacts on consumer side it's just a Junit test execution

>./gradlew clean test 

@PactVerification unit test will output the contract(s) on > ⁨build⁩ ▸ ⁨pacts⁩ 

contracts == json files with the name “consumername-providername.json” 


