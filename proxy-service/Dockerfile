FROM adoptopenjdk/openjdk11:ubuntu-slim
# copy application JAR (with libraries inside)
WORKDIR /proxy-service
COPY src/main/java ./src/main/java
COPY src/main/resources ./src/main/resources
COPY gradle ./gradle
COPY build.gradle ./
COPY gradlew ./
COPY gradlew.bat ./
COPY settings.gradle ./
RUN ./gradlew build
# specify default command
EXPOSE 9000
CMD ["java", "-jar", "build/libs/proxy-service-0.0.1-SNAPSHOT.jar"]