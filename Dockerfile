FROM openjdk:12-jdk-alpine
VOLUME /tmp
#COPY build/libs/crypto.jar crypto.jar
#ENTRYPOINT ["java","-jar","crypto.jar"]
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","crypto.App"]
