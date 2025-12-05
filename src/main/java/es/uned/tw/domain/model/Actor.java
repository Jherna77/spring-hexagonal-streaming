package es.uned.tw.domain.model;

import lombok.*;

/**
 * The type Actor.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Actor {
    private Long id;
    private String name;
}