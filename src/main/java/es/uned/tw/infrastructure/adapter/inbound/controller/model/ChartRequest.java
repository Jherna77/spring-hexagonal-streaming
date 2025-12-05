package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * The type Chart request.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ChartRequest {
    private String id;
    private String title;
    private List<List<Object>> rows;
    private Map<Object, Object> cols;
}
