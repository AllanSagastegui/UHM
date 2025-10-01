package pe.com.ask.elasticsearch.exceptions;

import pe.com.ask.model.baseexception.BaseException;
import pe.com.ask.model.baseexception.errors.ErrorCatalog;

public class AuditLogFindException extends BaseException {
    public AuditLogFindException() {
        super(
                ErrorCatalog.AUDIT_LOG_FIND_ERROR.getErrorCode(),
                ErrorCatalog.AUDIT_LOG_FIND_ERROR.getTitle(),
                ErrorCatalog.AUDIT_LOG_FIND_ERROR.getMessage(),
                ErrorCatalog.AUDIT_LOG_FIND_ERROR.getStatus(),
                ErrorCatalog.AUDIT_LOG_FIND_ERROR.getErrors()
        );
    }
}