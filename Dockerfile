FROM maven:3.5-jdk-8 as BUILD
WORKDIR /usr/src/app
COPY pom.xml /usr/src/app
COPY src /usr/src/app/src
RUN mvn install -DskipTests=true -Dmaven.javadoc.skip=true -B -V

FROM websphere-liberty:microProfile
RUN installUtility install  --acceptLicense defaultServer
COPY server.xml /config/server.xml
COPY --from=BUILD /usr/src/app/target/JavaHelloWorldApp.war /config/apps/
