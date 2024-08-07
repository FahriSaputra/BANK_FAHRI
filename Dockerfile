# Menggunakan image JDK 22 sebagai base image untuk membangun aplikasi
FROM openjdk:22-jdk AS build

# Set working directory
WORKDIR /app

# Menyalin file pom.xml dan kode sumber ke dalam image
COPY pom.xml .
COPY src ./src

# Membuat file JAR aplikasi
RUN ./mvnw package -DskipTests

# Menggunakan image JRE 22 sebagai base image untuk menjalankan aplikasi
FROM openjdk:22-jre

# Set working directory
WORKDIR /app

# Menyalin file JAR dari tahap build
COPY --from=build /app/target/*.jar app.jar

# Menentukan perintah untuk menjalankan aplikasi
ENTRYPOINT ["java", "-jar", "app.jar"]
