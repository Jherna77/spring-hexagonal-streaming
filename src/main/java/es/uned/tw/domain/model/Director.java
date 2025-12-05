package es.uned.tw.domain.model;

import lombok.*;

/**
 * The type Director.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Director {
    private Long id;
    private String name;
}
