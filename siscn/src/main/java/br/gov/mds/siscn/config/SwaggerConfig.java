package br.gov.mds.siscn.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("SISCN API")
                        .description("API do Sistema de Cadastro Nacional")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("MDS")
                                .email("suporte@mds.gov.br")));
    }
    
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public GroupedOpenApi entityApi() {
        return GroupedOpenApi.builder()
                .group("entities")
                .packagesToScan("br.gov.mds.siscn.entity")
                .build();
    }
}