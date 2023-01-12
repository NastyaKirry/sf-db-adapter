package ru.otr.sf.db.adapter.swagger;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "application.swagger.enabled", havingValue = "true")
public class SwaggerConfig {

//  http://localhost:8084/swagger-ui.html#/

    @Value("${application.swagger.title}")
    private String swaggerTitle;

    @Value("${application.swagger.description}")
    private String swaggerDescription;

    @Value("${application.swagger.version}")
    private String swaggerVersion;

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfo(
                swaggerTitle,
                swaggerDescription,
                swaggerVersion,
                "",
                new Contact("otr", "otr", "otr@otr.ru"),
                "",
                "",
                new ArrayList<>()
        );
    }

    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.otr"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("Bearer", "Authorization", "header");
    }



    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope(
                "global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("Bearer",
                authorizationScopes));
    }
}
