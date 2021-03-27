FROM openjdk:15-oracle

ADD target/webPortal-0.0.1-SNAPSHOT.jar Web-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/Web-app.jar"]