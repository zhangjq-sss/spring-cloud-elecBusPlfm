#!/bin/bash

source /etc/profile

export APP_PATH=$(cd "$(dirname "$0")"; pwd)
cd $APP_PATH
cd ..
export BASE_PATH=$(cd "$(dirname "$0")"; pwd)
cd $APP_PATH

./start-discovery-service1.sh
sleep 5
./start-discovery-service2.sh
sleep 5
./start-discovery-service3.sh
sleep 5
./start-config-service.sh
sleep 20
./start-auth-service.sh
sleep 5