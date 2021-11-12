FROM openjdk:11.0.11-jre
EXPOSE 8081
ADD target/spring-boot-docker.jar spring-boot-docker.jar

ENV DATABASE_HOST=localhost
ENV DATABASE_PORT=1433
ENV DATABASE_NAME=customer
ENV DATABASE_USERNAME=sa
ENV DATABASE_PASSWORD=123456789.z
ENV PORT=8081

ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]

