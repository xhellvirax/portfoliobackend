FROM amazoncorretto:11-alpine-jdk

MAINTAINER antonellaperlinghieri

COPY ./target/restapi-0.0.1-SNAPSHOT.jar restapi-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/restapi-0.0.1-SNAPSHOT.jar"]