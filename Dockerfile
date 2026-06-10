FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .
COPY src ./src
COPY testng.xml .


COPY src/test/resources/testFiles/ /app/testFiles/

RUN mvn dependency:resolve

CMD ["mvn", "test", "-DsuiteXmlFile=testng.xml", "-Dmaven.test.failure.ignore=true"]