package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Genre request.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class GenreRequest {
    private Long id;
    private String name;
}
