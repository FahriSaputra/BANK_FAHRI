FROM jtl-tkgiharbor.hq.bni.co.id/wss-dev/maven:3.8.5-openjdk-17-slim AS builder
#FROM maven:3.8.5-openjdk-17-slim AS builder
ENV HOME=/usr/app
RUN mkdir -p "$HOME"
WORKDIR $HOME
COPY .mvn/settings.xml /root/.m2/settings.xml
ADD pom.xml $HOME
RUN mvn -Dhttps.proxyHost=192.168.45.105 -Dhttps.proxyPort=8080 -Dserver.address=0.0.0.0 verify --fail-never
#RUN mvn verify --fail-never
ADD . $HOME
RUN mvn -Dhttps.proxyHost=192.168.45.105 -Dhttps.proxyPort=8080 -Dserver.address=0.0.0.0 -Dmaven.test.skip=true clean package
#RUN mvn -Dmaven.test.skip=true clean package

FROM jtl-tkgiharbor.hq.bni.co.id/wss-dev/eclipse-temurin:17.0.7_7-jre-alpine
#FROM eclipse-temurin:17.0.7_7-jre-alpine
LABEL org.opencontainers.image.authors="fahri"
#RUN mkdir -p /NFS/bs/
WORKDIR /app
#RUN chmod 775 /app /NFS/ \
#  && chown -R 1001 /app /NFS/ \
#  && chmod -R "g+rwX" /app /NFS/ \
#  && chown -R 1001:root /app /NFS/
COPY --from=builder /usr/app/target/*.jar ./BANK-FAHRI-0.0.1-SNAPSHOT.jar
EXPOSE 8080

# Variabel lingkungan untuk konfigurasi database
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/bank
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=root

#USER 1002
ENTRYPOINT ["java","-jar","BANK-FAHRI-0.0.1-SNAPSHOT.jar"]
