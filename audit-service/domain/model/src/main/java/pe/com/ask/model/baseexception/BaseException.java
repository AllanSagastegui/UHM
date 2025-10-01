package pe.com.ask.model.baseexception;

import lombok.Getter;

import java.time.Instant;
import java.util.Map;

@Getter
public class BaseException extends RuntimeException {
    private final String errorCode;
    private final String title;
    private final String message;
    private final int status;
    private final Instant timestamp;
    private final Map<String, String> errors;

    protected BaseException(String errorCode, String title, String message, int status, Map<String, String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.title = title;
        this.message = message;
        this.status = status;
        this.timestamp = Instant.now();
        this.errors = errors;
    }
}