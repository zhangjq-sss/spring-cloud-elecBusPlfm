cd /d %~dp0%
start java   -Duip=127.0.0.1  -Ddc1=127.0.0.1 -Ddc2=127.0.0.1 -Ddc3=127.0.0.1   -jar   target/poc-config-service-0.0.1-SNAPSHOT.jar