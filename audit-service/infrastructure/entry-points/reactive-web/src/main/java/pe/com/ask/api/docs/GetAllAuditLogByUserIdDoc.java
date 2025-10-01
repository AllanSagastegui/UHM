package pe.com.ask.api.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.ask.model.auditlog.AuditLog;
import pe.com.ask.model.utils.Pageable;
import reactor.core.publisher.Mono;

@Component
@Schema(
        name = "Consulta de AuditLogs por Usuario",
        description = "Documentación de la operación para obtener todos los registros de auditoría filtrados por userId con paginación."
)
public class GetAllAuditLogByUserIdDoc {

    @Operation(
            operationId = "getAllAuditLogsByUserId",
            summary = "Obtener AuditLogs de un usuario",
            description = "Devuelve una lista paginada de registros de auditoría asociados al `userId` proporcionado. " +
                    "Permite especificar la página y el tamaño de página para controlar la paginación de los resultados."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista paginada de AuditLogs",
                    content = @Content(
                            schema = @Schema(
                                    implementation = Pageable.class
                            )
                    )
            )
    })
    public Mono<Pageable<AuditLog>>  getAllAuditLogsByUserIdDoc(
            @Parameter(name = "page", description = "Número de página (por defecto: 0)")
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,

            @Parameter(name = "size", description = "Tamaño de página (por defecto: 10)")
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,

            @Parameter(name = "userId", description = "Filtrar por ID de usuario (userId)")
            @RequestParam(name = "userId", required = false) String userId
    ) {
        return Mono.empty();
    }
}