FROM openjdk:15-oracle

ADD target/authorizationService-0.0.1-SNAPSHOT.jar Auth-app.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","/Auth-app.jar"]