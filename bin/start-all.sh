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
#./start-monitor-service.sh
sleep 5
./start-config-service.sh
sleep 30
./start-auth-service.sh
sleep 5
./start-product-service.sh
sleep 5
./start-promotion-service.sh
sleep 5
./start-order-service.sh
sleep 5
./start-gateway-service.sh
sleep 5
./start-customer-service.sh
#sleep 5
#./start-zipkin-rabbitmq-mysql.sh

#sleep 5
#./start-payment-service.sh
#sleep 5
#./start-job-service.sh
#sleep 5
#./start-admin-service.sh
