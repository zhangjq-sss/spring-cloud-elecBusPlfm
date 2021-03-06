#!/bin/bash

source /etc/profile

export APP_PATH=$(cd "$(dirname "$0")"; pwd)
cd $APP_PATH
cd ..
export BASE_PATH=$(cd "$(dirname "$0")"; pwd)
cd $APP_PATH
export cmd="java -Xmx256m -Xms128m -Dspring.profiles.active=node2 -jar $BASE_PATH/lib/poc-discovery-service-0.0.1-SNAPSHOT.jar"


echo "execute [$cmd]"
nohup  $cmd  > /dev/null  2>&1 &


