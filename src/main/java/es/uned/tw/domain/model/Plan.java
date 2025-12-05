package es.uned.tw.domain.model;

import lombok.*;

import java.util.List;

/**
 * The type Plan.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Plan {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private List<Feature> features;
    private int duration;
}