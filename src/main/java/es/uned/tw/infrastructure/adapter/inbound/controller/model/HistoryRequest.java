package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * The type History request.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class HistoryRequest {
    private Long id;
    private UserRequest user;
    private ContentRequest content;
    private LocalDateTime date;
}
