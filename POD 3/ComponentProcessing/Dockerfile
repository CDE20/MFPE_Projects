FROM openjdk:15-oracle

ADD target/componentProcessModule-0.0.1-SNAPSHOT.jar Comp-app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/Comp-app.jar"]