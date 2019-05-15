项目后台服务中心模块介绍
##端口规划： 
dev环境
poc-config-service  	      01配置中心                8202
poc-discovery-service 	  02服务注册中心            三台 8205 高可用中心 需要配置本地id与dc1.poc.com dc2.poc.com dc3.poc.com映射
poc-discovery-service2 	  02服务注册中心2           8206
poc-discovery-service3 	  02服务注册中心3 			  8207
poc-gateway-service 	      03服务API网关             8210
poc-auth-service        	  04认证中心                9050
poc-common-util     		  05工具基础库
poc-domain-model    		  06公用领域模型
poc-order-service   	      07订单服务                9001
poc-product-service        08产商品服务			  9010
poc-promotion-service      9促销服务                 9020
poc-payment-service        10支付服务                9030
poc-job                    11批量任务                9060
poc-customer-service       12 客户服务               9040
poc-monitor-service        13 监控服务               8220
poc-monitor-service        15 监控服务               9070
后台脱离
poc-admin-service           14 用户服务 用作后台管理    8080