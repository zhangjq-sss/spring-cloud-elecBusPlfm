# spring-cloud-elecBusPlfm
分布式电商平台

技术概要：Springboot springcloud mysql redis rabbitmq

springcloud概要：高可用注册中心3个 配置中心（git）2个 熔断器hystrix使用 rpc采用feign调用外部服务 rabbit超时时间 gateway网关采用serviceId模式                 和zuul进行路由（其中包括token、路由过滤器） RateLimitZuulFilter限流处理
