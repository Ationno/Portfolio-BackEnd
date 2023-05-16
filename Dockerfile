FROM amazoncorretto:17

MAINTAINER Ationno
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]