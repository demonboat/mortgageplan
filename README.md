# Codetest - Mortgage Plan

## Dependencies
* Java 17
* Node.js & NPM
* Docker or Podman
* podman-compose or docker-compose

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
Start the applications through podman & podman-compose
```shell
$ podman-compose up
```
There's also an option to run the applications as separate docker containers without the use of docker/podman-compose
Inside of the mortgage plan directory do this:
```shell
$ podman build --tag backend -f Dockerfile
$ cd frontend
$ podman build --tag frotnend -f Dockerfile
$ podman run -dit -p 8080:8080 backend
$ podman run -dit -p 3000:3000 frontend
```
The website is up on `http://localhost:3000/` and the OpenAPI documentation exists on `http://localhost:8080/`

As the OpenAPI documentation exists, usage of REST clients such as Postman or Insomnia is encouraged.