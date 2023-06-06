# Utilizar una imagen base con Java y Maven instalados
FROM maven:3.8.4-openjdk-8-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el código fuente al directorio de trabajo
COPY . .

# Empaquetar la aplicación
RUN mvn clean package -DskipTests

# Establecer las variables de entorno para la conexión a la base de datos
ENV DB_HOST 3.139.107.26
ENV DB_PORT 3306
ENV DB_NAME database-screenspace
ENV DB_USER admin
ENV DB_PASSWORD screenspace

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para iniciar la aplicación
CMD ["java", "-cp", "target/classes", "com.example.screenspace.ScreenspaceApplication"]
