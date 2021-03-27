FROM openjdk:8
ADD target/audit-benchmark.jar audit-benchmark.jar
EXPOSE 9093
ENTRYPOINT ["java","-jar","/audit-benchmark.jar"]