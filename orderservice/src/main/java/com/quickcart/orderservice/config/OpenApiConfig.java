package com.quickcart.orderservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI orderServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("QuickCart Order Service API")
                        .description("APIs for managing user orders in QuickCart")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("QuickCart Team")
                                .email("support@quickcart.com")
                                .url("https://quickcart.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("QuickCart Wiki Documentation")
                        .url("https://quickcart.com/docs"));
    }
}
