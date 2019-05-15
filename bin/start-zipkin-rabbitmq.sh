#!/bin/bash

source /etc/profile

export APP_PATH=$(cd "$(dirname "$0")"; pwd)
cd $APP_PATH
cd ..
export BASE_PATH=$(cd "$(dirname "$0")"; pwd)
cd $APP_PATH

export cmd="RABBIT_ADDRESSES=localhost  java -Xms256m -Xmx256m -XX:NewRatio=2 -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=75 -XX:+HeapDumpOnOutOfMemoryError -jar  $BASE_PATH/lib/zipkin.jar"


echo "execute [$cmd]"
nohup  $cmd  > /dev/null  2>&1 &


