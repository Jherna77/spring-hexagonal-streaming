package es.uned.tw.domain.model;

import lombok.*;

/**
 * The type Feature.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Feature {
    private Long id;
    private String name;
    private String tag;
}
