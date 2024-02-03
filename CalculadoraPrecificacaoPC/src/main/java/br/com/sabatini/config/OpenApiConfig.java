package br.com.sabatini.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Calculadora para a Precificação de Produtos e de Gastos com Matérias-Primas")
                        .version("v1")
                        .description("O projeto é uma API desenvolvida com o objetivo" +
                                "de fornecer uma interface para o cálculo realizado" +
                                "na precificação de produtos para posterior venda e para o " +
                                "cálculo de gastos com as matérias-primas utilizadas em seus produtos.")
                        .license(new License()
                                .name("GPL-3.0")));
    }
}
