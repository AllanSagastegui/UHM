package pe.com.ask.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "UHM - AditLog API",
                version = "1.0",
                description = "Este API permite la gestión y consulta de registros de auditoría (AuditLogs) generados por los distintos servicios de UHM. " +
                        "Se pueden registrar eventos de usuario, acciones de servicios y detalles específicos para fines de seguimiento y análisis.",
                contact = @Contact(
                        name = "Allan Sagastegui Herrada",
                        email = "allansagasteguih@gmail.com",
                        url = "https://github.com/AllanSagastegui/UHM"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        )
)
public class OpenApiConfig { }