package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * The type Play list request.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PlayListRequest {
    private UserRequest user;
    private ContentRequest content;
    private LocalDateTime date;
}