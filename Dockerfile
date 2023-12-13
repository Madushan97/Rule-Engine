FROM openjdk:17
ADD target/rule-engine-docker.jar rule-engine-docker.jar
EXPOSE 9091
ENTRYPOINT ["java", "-jar", "/rule-engine-docker.jar"]

