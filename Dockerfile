FROM openjdk:17 AS build
WORKDIR /var/src

# Download gradle
COPY gradlew .
COPY gradle/ gradle/
RUN ./gradlew --no-daemon --version

# Build
COPY . .
RUN ./gradlew --no-daemon clean build

FROM openjdk:17-jre
WORKDIR /var/app

COPY --from=build /var/src/build/libs/* ./

EXPOSE 8080

ENTRYPOINT ["java","-Dserver.port=8080", "-jar", "backend.jar"]