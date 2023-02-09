FROM openjdk:11

MAINTAINER antonellaperlinghieri

COPY target/restapi-0.0.1-SNAPSHOTjar restapi-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/restapi-0.0.1-SNAPSHOT.jar"]