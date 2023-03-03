# Codetest - Mortgage Plan

## Features
- Calculated the fixed monthly rate and apply it in the console.
- Validated all data in and out of the Application using simple checks to see if the data was somehow much bigger than anticipated or simply null.
- Laid it all on top of Spring Boot 3 & added OpenAPI 3 with Spring doc ui in order to get a dev view of the endpoints as well as being able to call them.
- There is no persistent storage except for the prospects file itself so any new entry will only be around as long as the application is running.

## Usage Dependencies
* Java 17
* Node.js & NPM
* Docker or Podman

## Run Instructions
In order to run the backend, use following command:
```shell
$ ./gradlew bootRun
```
In order to do test the application use this:
```shell
$ ./gradlew clean build
```
In order to run the frontend, use this:
```shell
$ npm install && npm start
```
Start the applications through docker & docker-compose
```shell
$ docker-compose up
```
