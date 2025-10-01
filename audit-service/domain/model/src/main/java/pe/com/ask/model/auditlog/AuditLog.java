package pe.com.ask.model.auditlog;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AuditLog {
    private String id;
    private String service;
    private String action;
    private String userId;
    private Instant timestamp;
    private String details;
}