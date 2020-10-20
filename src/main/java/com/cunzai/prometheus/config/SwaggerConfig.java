package com.cunzai.prometheus.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${spring.profiles.active:dev}")
    private String environment;

    /**
     * @return
     */
    @Bean
    public Docket createRestApi(ServletContext servletContext) {
        List<Parameter> pars = new ArrayList<>();
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).ignoredParameterTypes(Map.class, ModelMap.class, RedirectAttributesModelMap.class)
                .enable("dev".equals(environment) || "test".equals(environment))//生产环境禁用。
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cunzai.prometheus.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("演示 Api文档")
                .description("演示 Api文档")
                .termsOfServiceUrl("")
                .version("1.0").license("zylc@2020").build();
    }
}
