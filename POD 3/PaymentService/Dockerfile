FROM openjdk:15-oracle

ADD target/paymentService-0.0.1-SNAPSHOT.jar Pay-app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/Pay-app.jar"]