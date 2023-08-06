FROM maven:3.9-eclipse-temurin-17-alpine AS test

WORKDIR /workdir/server
COPY pom.xml /workdir/server/pom.xml
RUN mvn dependency:go-offline

COPY src /workdir/server/src
RUN mvn install -DskipTests

CMD ["mvn", "spring-boot:run"]

FROM test AS build-prod
RUN mkdir -p target/dependency
WORKDIR /workdir/server/target/dependency
RUN jar -xf ../*.jar

FROM eclipse-temurin:17-jre-alpine AS prod

EXPOSE 8081
VOLUME /tmp
ARG DEPENDENCY=/workdir/server/target/dependency
COPY --from=build-prod ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build-prod ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build-prod ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.jlinden.todorest.TodoRestApplication"]
