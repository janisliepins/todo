FROM maven:3.9-eclipse-temurin-17-alpine AS builder

WORKDIR /workdir/server
COPY pom.xml /workdir/server/pom.xml
RUN mvn dependency:go-offline

COPY src /workdir/server/src

CMD ["mvn", "spring-boot:run"]
