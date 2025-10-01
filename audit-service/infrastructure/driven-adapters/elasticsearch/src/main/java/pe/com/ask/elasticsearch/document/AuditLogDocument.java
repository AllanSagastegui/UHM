package pe.com.ask.elasticsearch.document;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Document(indexName = "audit-logs")
public class AuditLogDocument {
    @Id
    private String id;
    private String service;
    private String action;
    private String userId;

    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private Instant timestamp;
    private String details;
}