FROM maven:3.8.4-openjdk-11-slim

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

RUN rm -rf target

COPY src ./src

ENV DB_HOST database-screenspace-instance-1.cfo9syysrsej.us-east-2.rds.amazonaws.com
ENV DB_PORT 3306
ENV DB_NAME screenspace
ENV DB_USER admin
ENV DB_PASSWORD screenspace

RUN mvn clean package -DskipTests -X

CMD ["java", "-jar", "target/screenspace-backend.jar"]
