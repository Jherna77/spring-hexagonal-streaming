package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * The type Rating request.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class RatingRequest {
    private UserRequest user;
    private ContentRequest content;
    private Integer rating;
    private LocalDateTime date;
}
