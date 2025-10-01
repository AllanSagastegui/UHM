package pe.com.ask.model.auditlog.gateways;

import pe.com.ask.model.auditlog.AuditLog;
import pe.com.ask.model.utils.Pageable;
import reactor.core.publisher.Mono;


public interface AuditLogRepository {
    Mono<AuditLog> save(AuditLog auditLog);
    Mono<Pageable<AuditLog>> findByUserId(String userId, int page, int size);
}