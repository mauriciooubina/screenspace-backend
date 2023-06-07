# Utilizar una imagen base con Java y Maven instalados
FROM maven:3.8.4-openjdk-8-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el código fuente al directorio de trabajo
COPY . .

# Empaquetar la aplicación
RUN mvn clean package -DskipTests

# Establecer las variables de entorno para la conexión a la base de datos
ENV DB_HOST database-screenspace-instance-1.cfo9syysrsej.us-east-2.rds.amazonaws.com
ENV DB_PORT 3306
ENV DB_NAME screenspace
ENV DB_USER admin
ENV DB_PASSWORD screenspace

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para iniciar la aplicación
CMD ["java", "-jar", "target/swagger-spring-1.0.0.jar"]

