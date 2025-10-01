package pe.com.ask.elasticsearch.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import pe.com.ask.elasticsearch.document.AuditLogDocument;
import reactor.core.publisher.Flux;

public interface AuditLogReactiveRepository extends ReactiveElasticsearchRepository<AuditLogDocument, String> {
    Flux<AuditLogDocument> findAllByUserId(String userId, Pageable pageable);
}