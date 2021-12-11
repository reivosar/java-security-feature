FROM openjdk:11-slim
ARG JAR_FILE=build/libs/\*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]
