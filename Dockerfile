FROM eclipse-temurin:17-ubi9-minimal AS build
WORKDIR /var/src

# Download gradle
COPY gradlew .
COPY gradle/ gradle/
RUN ./gradlew --no-daemon --version

# Build
COPY . .
RUN ./gradlew --no-daemon clean build

FROM eclipse-temurin:17-jre-ubi9-minimal
WORKDIR /var/app

COPY --from=build /var/src/build/libs/* ./

EXPOSE 8080

ENTRYPOINT ["java","-Dserver.port=8080", "-jar", "mortgageplan-0.0.1-SNAPSHOT.jar"]