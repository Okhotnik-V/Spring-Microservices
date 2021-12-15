FROM amazoncorretto:15
EXPOSE 8088
ADD target/main.jar main.jar
COPY Text.txt ./
COPY Result.txt ./
ENTRYPOINT ["java", "-jar", "main.jar"]