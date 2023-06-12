FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY pom.xml .

RUN apk add --no-cache curl && \
    curl -L "https://github.com/swagger-api/swagger-codegen/releases/download/v3.0.0/swagger-codegen-cli-3.0.0.jar" -o swagger-codegen-cli.jar && \
    mvn dependency:go-offline -B

COPY src ./src

ENV DB_HOST database-screenspace-instance-1.cfo9syysrsej.us-east-2.rds.amazonaws.com
ENV DB_PORT 3306
ENV DB_NAME screenspace
ENV DB_USER admin
ENV DB_PASSWORD screenspace

RUN mvn clean package -DskipTests

CMD ["java", "-jar", "target/screenspace-backend.jar"]
