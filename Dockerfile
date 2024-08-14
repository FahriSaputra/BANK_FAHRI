# the base image
FROM amazoncorretto:17

# the JAR file path
ARG JAR_FILE=target/*.jar

# Copy the JAR file from the build context into the Docker image
COPY ${JAR_FILE} BANK-FAHRI.jar

CMD apt-get update -y

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/bank
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=root

# Set the default command to run the Java application
ENTRYPOINT ["java", "-jar", "BANK-FAHRI.jar"]