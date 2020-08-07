FROM adoptopenjdk/openjdk11:ubuntu-slim
# copy application JAR (with libraries inside)
WORKDIR /log-service
COPY src/main/java ./src/main/java
COPY src/main/resources ./src/main/resources
COPY gradle ./gradle
COPY build.gradle ./
COPY gradlew ./
COPY gradlew.bat ./
COPY settings.gradle ./
RUN ./gradlew build
# specify default command
EXPOSE 9002
CMD ["java", "-jar", "build/libs/log-service-1.0-SNAPSHOT.jar"]