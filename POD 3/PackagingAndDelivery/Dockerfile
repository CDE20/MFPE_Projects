FROM openjdk:15-oracle

ADD target/packageDeliveryModule-0.0.1-SNAPSHOT.jar Pack-app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/Pack-app.jar"]