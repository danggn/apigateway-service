FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
#COPY src/main/resources/baeldung.p12
COPY ${JAR_FILE} CustomerApigatewayService.jar
ENTRYPOINT ["java","-jar","CustomerApigatewayService.jar"]
