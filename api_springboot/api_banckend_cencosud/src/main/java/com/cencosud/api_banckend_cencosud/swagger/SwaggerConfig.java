package com.cencosud.api_banckend_cencosud.swagger;


import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
@Configuration

public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("localhost:8080");
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl("localhost:8080");
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setUrl("https://github.com/Gu1lLherme/SQUAD-13");
        contact.setName("SQUAD-13");

        Info info = new Info()
                .title("SCAA Cencosud")
                .version("1.3")
                .contact(contact)
                .description("Sistema de Coesão e Acoplamento de APi's");

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}