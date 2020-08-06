FROM adoptopenjdk/openjdk11:ubuntu-slim
# copy application JAR (with libraries inside)
WORKDIR /user-service
COPY src/main/kotlin ./src/main/kotlin
COPY src/main/resources ./src/main/resources
COPY gradle ./gradle
COPY build.gradle.kts ./
COPY gradlew ./
COPY gradlew.bat ./
COPY settings.gradle.kts ./
RUN ./gradlew build
# specify default command
EXPOSE 9001
CMD ["java", "-jar", "build/libs/user-service-0.0.1-SNAPSHOT.jar"]