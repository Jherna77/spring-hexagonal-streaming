package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * The type Plan request.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PlanRequest {
    private Long id;
    private String name;
    private String description;
    private Integer duration;
    private Double price;
    private List<FeatureRequest> features;
}
