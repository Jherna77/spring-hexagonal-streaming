package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Director request.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DirectorRequest {
    private Long id;
    private String name;
}
