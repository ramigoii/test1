FROM eclipse-temurin:21-jdk
MAINTAINER Ramina
COPY backend.jar playlist.jar
ENTRYPOINT ["java", "-jar", "playlist.jar"]