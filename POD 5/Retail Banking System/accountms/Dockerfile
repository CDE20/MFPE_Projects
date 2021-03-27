FROM openjdk:8u131-jdk-alpine
EXPOSE 8086
COPY ./target/account-service.jar account-service.jar 
ENTRYPOINT ["java","-jar","/account-service.jar"]