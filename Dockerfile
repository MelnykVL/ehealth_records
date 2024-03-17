FROM tomcat:9-jdk11

COPY ./target/ehealth_records-1.0.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]