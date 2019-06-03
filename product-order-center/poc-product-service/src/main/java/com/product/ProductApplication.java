package com.product;

import java.io.File;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableDistributedTransaction
@SpringBootApplication
@MapperScan({"com.product.mapper"})
@EnableEurekaClient
@EnableTransactionManagement   //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
@EnableSwagger2
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class ProductApplication{

    private static final String FILE_UPLOAD_PATH = "/alidata/server/poc/temp";

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	
	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.product.web"))
					.paths(PathSelectors.any()).build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("产品订单中心-产商品服务API说明文档").description("2018.05.25").build());
	}


	/**
	 * 文件上传临时路径
	 */
	@Bean
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();

        String absTempPath = new File(FILE_UPLOAD_PATH).getAbsolutePath();

        File attachpath = new File(absTempPath);

        if(!attachpath.exists()){
            attachpath.mkdirs();
        }
        factory.setLocation(absTempPath);
		return factory.createMultipartConfig();
	}
}
