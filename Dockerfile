
FROM openjdk:17-oracle
EXPOSE 8180
ADD target/rule-engine-docker.jar rule-engine-docker.jar
ENTRYPOINT ["java", "-jar", "/rule-engine-docker.jar"]

