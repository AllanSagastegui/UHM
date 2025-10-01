package pe.com.ask.usecase.saveauditlog;

import lombok.RequiredArgsConstructor;
import pe.com.ask.model.auditlog.AuditLog;
import pe.com.ask.model.auditlog.gateways.AuditLogRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SaveAuditLogUseCase {
    private final AuditLogRepository  auditLogRepository;

    public Mono<Void> execute(AuditLog auditLog) {
        return auditLogRepository.save(auditLog)
                .then();
    }
}