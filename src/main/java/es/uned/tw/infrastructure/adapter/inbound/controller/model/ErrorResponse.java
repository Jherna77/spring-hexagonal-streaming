package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * The type Error response.
 */
@Builder
@Data
@ToString
public class ErrorResponse {
    private final Integer code;
    private final String cause;
}
