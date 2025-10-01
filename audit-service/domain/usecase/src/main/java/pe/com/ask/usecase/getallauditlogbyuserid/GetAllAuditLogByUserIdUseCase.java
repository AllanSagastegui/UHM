package pe.com.ask.usecase.getallauditlogbyuserid;

import lombok.RequiredArgsConstructor;
import pe.com.ask.model.auditlog.AuditLog;
import pe.com.ask.model.auditlog.gateways.AuditLogRepository;
import pe.com.ask.model.utils.Pageable;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetAllAuditLogByUserIdUseCase {
    private final AuditLogRepository auditLogRepository;

    public Mono<Pageable<AuditLog>> execute(String userId, int page, int size) {
        return auditLogRepository.findByUserId(userId, page, size);
    }
}