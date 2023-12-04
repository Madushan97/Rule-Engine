
FROM openjdk:17-oracle
ADD target/rule-engine-docker.jar rule-engine-docker.jar
#EXPOSE 8180
ENTRYPOINT ["java", "-jar", "/rule-engine-docker.jar"]

