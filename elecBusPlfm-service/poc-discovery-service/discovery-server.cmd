cd /d %~dp0%
start java   -Dspring.profiles.active=node1 -Ddc1=127.0.0.1 -Ddc2=127.0.0.1 -Ddc3=127.0.0.1  -jar   target/poc-discovery-service-0.0.1-SNAPSHOT.jar
start java   -Dspring.profiles.active=node2 -Ddc1=127.0.0.1 -Ddc2=127.0.0.1 -Ddc3=127.0.0.1  -jar   target/poc-discovery-service-0.0.1-SNAPSHOT.jar
start java   -Dspring.profiles.active=node3 -Ddc1=127.0.0.1 -Ddc2=127.0.0.1 -Ddc3=127.0.0.1  -jar   target/poc-discovery-service-0.0.1-SNAPSHOT.jar
