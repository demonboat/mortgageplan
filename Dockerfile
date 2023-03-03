FROM gradle:latest AS build
WORKDIR /usr/app

COPY . . 
RUN gradle build || return 1

# Build
FROM eclipse-temurin:17-jre-ubi9-minimal
ENV JAR_NAME=mortgageplan-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

COPY --from=build $APP_HOME .

EXPOSE 8080

ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME
