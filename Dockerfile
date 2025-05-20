FROM gradle:8.5-jdk17 AS builder
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle bootJar

FROM eclipse-temurin:17-jdk-jammy

RUN useradd -m -d /home/ykx -s /bin/bash ykx
USER ykx
RUN whoami

WORKDIR /home/ykx/app

COPY --from=builder /app/build/libs/*.jar app.jar

ENV DB_HOST=postgres-dimdim \
    DB_PORT=5432 \
    DB_NAME=jogosdb \
    DB_USER=user \
    DB_PASS=passwd


EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
