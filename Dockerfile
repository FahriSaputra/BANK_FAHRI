# Tahap build: menggunakan Maven dengan Java 17
FROM maven:3.8-openjdk-17 AS build

# Set direktori kerja di dalam container
WORKDIR /app

# Salin pom.xml dan file lainnya yang diperlukan
COPY pom.xml .

# Salin direktori src
COPY src ./src

# Bangun aplikasi
RUN mvn clean package -DskipTests

# Tahap runtime: menggunakan OpenJDK 17 untuk menjalankan aplikasi
FROM openjdk:17-jdk-slim

# Set direktori kerja di dalam container
WORKDIR /app

# Salin file jar yang telah dibangun dari tahap sebelumnya
COPY --from=build /app/target/BANK-FAHRI-0.0.1-SNAPSHOT.jar BANK-FAHRI.jar

# Variabel lingkungan untuk konfigurasi database
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/bank
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=root

# Perintah untuk menjalankan aplikasi
ENTRYPOINT ["java", "-jar", "BANK-FAHRI.jar"]
