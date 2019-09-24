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

## run pact tests 
running pacts on consumer side it's just a Junit test execution
>./gradlew clean test 
