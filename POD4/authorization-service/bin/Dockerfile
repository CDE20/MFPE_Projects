FROM openjdk:8u131-jdk-alpine
EXPOSE 9092
COPY ./target/authorization-service-0.0.1-SNAPSHOT.jar authorization-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/authorization-service-0.0.1-SNAPSHOT.jar"]