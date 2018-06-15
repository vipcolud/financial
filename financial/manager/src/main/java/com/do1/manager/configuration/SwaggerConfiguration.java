package com.do1.manager.configuration;



import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * swagger 配置类  
 * 只需要添加maven依赖和填加该配置类就可以自带生成swagger-ui 
 * 访问http://localhost:8082/seller/swagger-ui.html
 */
/*@Configuration
@ComponentScan(basePackages = "com.do1.swagger")
@EnableSwagger2*/
public class SwaggerConfiguration {


    @Bean
    public Docket controllerApi() {
       return    new Docket(DocumentationType.SWAGGER_2)
                .groupName("controller")
                .apiInfo(apiInfo())
                .select()
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("管理端api")
                .description("API")
                .termsOfServiceUrl("http://springfox.io")
                .contact("do1")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
}
