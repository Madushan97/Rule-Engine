
FROM adoptopenjdk/openjdk17:alpine
ADD target/rule-engine-docker.jar rule-engine-docker.jar
ENTRYPOINT ["java", "-jar", "/rule-engine-docker.jar"]

