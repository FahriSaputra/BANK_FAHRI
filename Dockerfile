# Menggunakan image JDK 17 sebagai base image untuk membangun aplikasi
FROM openjdk:17-jdk-slim AS build

# Set working directory
WORKDIR /app

# Menyalin file pom.xml dan kode sumber ke dalam image
COPY pom.xml .
COPY src ./src
COPY mvnw .
COPY .mvn .mvn

# Mengatur izin eksekusi untuk mvnw
RUN chmod +x ./mvnw

# Menjalankan perintah Maven untuk membangun aplikasi
RUN ./mvnw package -DskipTests

# Menggunakan image JRE 17 sebagai base image untuk menjalankan aplikasi
FROM openjdk:17-jre-slim

# Set working directory
WORKDIR /app

# Menyalin file JAR dari tahap build
COPY --from=build /app/target/*.jar app.jar

# Menentukan perintah untuk menjalankan aplikasi
ENTRYPOINT ["java", "-jar", "app.jar"]
