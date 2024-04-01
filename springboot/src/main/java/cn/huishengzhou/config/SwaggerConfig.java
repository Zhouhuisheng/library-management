package cn.huishengzhou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 // 开启Swagger2
public class SwaggerConfig {

    // 配置Swagger信息 apiInfo
    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("周辉生", "", "391030990@qq.com");

        return new ApiInfo("图书管理系统的Api Documentation",
                "此系统为图书管理系统，可以实现管理员操作、用户操作、图书分类操作、图书操作、借还书操作等 ",
                "1.0",
                "",
                contact,
                "前端web界面，请按照原始配置进行部署即可跳转",
                "http://localhost:8080/login",
                new ArrayList());
    }

    // 配置docket的Bean实例
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // RequestHandlerSelectors:配置要扫描接口的方式
                // basePackage（）：扫描指定的包
                // any()：扫描全部
                // none()：不扫描
                // withMethodAnnotation():扫描方法上的注解
                // withClassAnnotation():扫描类上的注解
                .apis(RequestHandlerSelectors.basePackage("cn.huishengzhou.controller"))
                // paths():过滤什么路径
//                .paths()
                .build();
    }
}
