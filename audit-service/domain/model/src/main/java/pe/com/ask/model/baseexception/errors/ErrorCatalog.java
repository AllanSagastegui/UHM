package pe.com.ask.model.baseexception.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public enum ErrorCatalog {
    AUDIT_LOG_SAVE_ERROR(
            "AUDIT_LOG_SAVE_ERROR",
            "Error al guardar AuditLog",
            "Ocurrió un error inesperado al intentar guardar el AuditLog.",
            500,
            null
    ),
    AUDIT_LOG_FIND_ERROR(
            "AUDIT_LOG_FIND_ERROR",
            "Error al obtener AuditLogs",
            "Ocurrió un error inesperado al listar los AuditLogs.",
            500,
            null
    );
    private final String errorCode;
    private final String title;
    private final String message;
    private final int status;
    private final Map<String, String> errors;
}