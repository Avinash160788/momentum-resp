FROM Openjdk:8
ARG JAR_FILE=target/UnitConversion-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} UnitConversion.jar
EXPOSE 8080
ENTRYPOINT {"java","-jar","UnitConversion.jar"}