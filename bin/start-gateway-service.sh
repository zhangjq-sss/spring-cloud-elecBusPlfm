#!/bin/bash

source /etc/profile

export APP_PATH=$(cd "$(dirname "$0")"; pwd)
cd $APP_PATH
cd ..
export BASE_PATH=$(cd "$(dirname "$0")"; pwd)
cd $APP_PATH

export cmd="java -Xms2048m -Xmx2048m -XX:NewRatio=2 -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=75 -XX:+HeapDumpOnOutOfMemoryError  -Dspring.profiles.active=dev  -jar  $BASE_PATH/lib/poc-gateway-service-0.0.1-SNAPSHOT.jar"



echo "execute [$cmd]"
nohup  $cmd  > /dev/null  2>&1 &


