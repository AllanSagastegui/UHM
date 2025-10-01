package pe.com.ask.elasticsearch.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import pe.com.ask.elasticsearch.exceptions.AuditLogFindException;
import pe.com.ask.elasticsearch.exceptions.AuditLogSaveException;
import pe.com.ask.elasticsearch.mapper.AuditLogMapper;
import pe.com.ask.model.auditlog.AuditLog;
import pe.com.ask.model.auditlog.gateways.AuditLogRepository;
import pe.com.ask.model.utils.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class AuditLogReactiveRepositoryAdapter implements AuditLogRepository {

    private final AuditLogReactiveRepository  auditLogReactiveRepository;
    private final AuditLogMapper mapper;

    @Override
    public Mono<AuditLog> save(AuditLog auditLog) {
        return Mono.just(auditLog)
                .map(mapper::toEntity)
                .flatMap(auditLogReactiveRepository::save)
                .map(mapper::toDomain)
                .onErrorResume(
                        ex -> Mono.error(new AuditLogSaveException())
                );
    }

    @Override
    public Mono<Pageable<AuditLog>> findByUserId(String userId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return auditLogReactiveRepository.findAllByUserId(userId, pageRequest)
                .map(mapper::toDomain)
                .collectList()
                .map(list -> Pageable.<AuditLog>builder()
                        .content(list)
                        .page(page)
                        .size(size)
                        .totalElements(list.size())
                        .totalPages(0)
                        .build()
                )
                .onErrorResume(ex -> Mono.error(new AuditLogFindException()));
    }
}