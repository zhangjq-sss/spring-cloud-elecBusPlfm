#!/bin/bash

source /etc/profile

export APP_PATH=$(cd "$(dirname "$0")"; pwd)
cd $APP_PATH
cd ..
export BASE_PATH=$(cd "$(dirname "$0")"; pwd)
cd $APP_PATH

export cmd="java -Xms256m -Xmx256m -jar $BASE_PATH/lib/zipkin.jar  --RABBIT_ADDRESSES=192.168.18.150:5672 --RABBIT_PASSWORD=cloud --RABBIT_USER=cloud"


echo "execute [$cmd]"
nohup  $cmd  > /dev/null  2>log &

