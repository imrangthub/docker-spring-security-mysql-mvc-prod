FROM openjdk:8-jdk-alpine
MAINTAINER imranmadbar@gmail.com
COPY target/docker-spring-security-mysql-mvc-prod-1.0.1.RELEASE.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]