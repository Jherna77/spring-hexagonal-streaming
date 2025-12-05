package es.uned.tw.domain.model;

import lombok.*;

/**
 * The type Content type.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ContentType {
    private Long id;
    private String name;
    private String tag;
}
