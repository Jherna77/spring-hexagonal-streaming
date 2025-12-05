package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Feature request.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class FeatureRequest {
    private Long id;
    private String name;
    private String tag;
}
