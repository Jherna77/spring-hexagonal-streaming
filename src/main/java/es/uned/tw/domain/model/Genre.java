package es.uned.tw.domain.model;

import lombok.*;

/**
 * The type Genre.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Genre {
    private Long id;
    private String name;
}