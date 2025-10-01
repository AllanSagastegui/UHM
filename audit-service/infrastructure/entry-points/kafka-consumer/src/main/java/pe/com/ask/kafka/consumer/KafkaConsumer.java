package pe.com.ask.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Component;
import pe.com.ask.model.auditlog.AuditLog;
import pe.com.ask.usecase.saveauditlog.SaveAuditLogUseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
@Log4j2
@RequiredArgsConstructor
public class KafkaConsumer {
    private final ReactiveKafkaConsumerTemplate<String, String> reactiveKafkaConsumer;
    private final ObjectMapper objectMapper;
    private final SaveAuditLogUseCase saveAuditLogUseCase;

    @EventListener(ApplicationStartedEvent.class)
    public Flux<Void> listenMessages() {
        return reactiveKafkaConsumer
                .receiveAutoAck()
                .publishOn(Schedulers.boundedElastic())
                .flatMap(auditLog ->
                    Mono.fromCallable(() -> objectMapper.readValue(auditLog.value(), AuditLog.class))
                            .subscribeOn(Schedulers.boundedElastic())
                            .flatMap(saveAuditLogUseCase::execute)
                )
                .doOnError(error -> log.error("Error processing kafka record", error))
                .retry()
                .repeat();
    }
}
