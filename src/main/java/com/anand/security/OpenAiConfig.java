package com.anand.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RecipeRendezvous API")
                        .version("1.0")
                        .description("This is a RecipeRendezvous API")
                        .contact(new Contact()
                                .name("Anand")
                                .email("anandrawool9999@gmail.com")
                                .url("https://www.linkedin.com/in/anand-rawool-96a8bb1aa/")));
    }
}