package pe.com.ask.elasticsearch.exceptions;

import pe.com.ask.model.baseexception.BaseException;
import pe.com.ask.model.baseexception.errors.ErrorCatalog;

public class AuditLogSaveException extends BaseException {
    public AuditLogSaveException() {
        super(
                ErrorCatalog.AUDIT_LOG_SAVE_ERROR.getErrorCode(),
                ErrorCatalog.AUDIT_LOG_SAVE_ERROR.getTitle(),
                ErrorCatalog.AUDIT_LOG_SAVE_ERROR.getMessage(),
                ErrorCatalog.AUDIT_LOG_SAVE_ERROR.getStatus(),
                ErrorCatalog.AUDIT_LOG_SAVE_ERROR.getErrors()
        );
    }
}