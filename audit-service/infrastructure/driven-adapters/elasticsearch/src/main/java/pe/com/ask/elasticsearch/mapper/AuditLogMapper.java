package pe.com.ask.elasticsearch.mapper;

import org.mapstruct.Mapper;
import pe.com.ask.elasticsearch.document.AuditLogDocument;
import pe.com.ask.model.auditlog.AuditLog;

@Mapper(componentModel = "spring")
public interface AuditLogMapper {
    AuditLog toDomain(AuditLogDocument auditLogDocument);
    AuditLogDocument toEntity(AuditLog auditLog);
}