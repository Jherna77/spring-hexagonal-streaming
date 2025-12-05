package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Content type request.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ContentTypeRequest {
    private Long id;
    private String name;
    private String tag;
}
