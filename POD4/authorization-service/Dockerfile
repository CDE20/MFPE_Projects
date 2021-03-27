FROM java:8-jdk-alpine
EXPOSE 8080
COPY ./target/Account-Microservice-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch Account-Microservice-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","Account-Microservice-0.0.1-SNAPSHOT.jar"]
