FROM amazoncorretto:19-alpine-jdk

MAINTAINER Ationno
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080