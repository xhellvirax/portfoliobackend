FROM openjdk:11

MAINTAINER antonellaperlinghieri

COPY target/demo-0.0.1-SNAPSHOTjar demo-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/demo-0.0.1-SNAPSHOT.jar"]