FROM maven:3.8.4-openjdk-8-slim

WORKDIR /app

COPY . .

ENV DB_HOST database-screenspace-instance-1.cfo9syysrsej.us-east-2.rds.amazonaws.com
ENV DB_PORT 3306
ENV DB_NAME screenspace
ENV DB_USER admin
ENV DB_PASSWORD screenspace

CMD ["mvn", "spring-boot:run"]

