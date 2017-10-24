FROM websphere-liberty:microProfile
RUN installUtility install  --acceptLicense defaultServer
COPY server.xml /config/server.xml
COPY target/JavaHelloWorldApp.war /config/apps/
