package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * The type Subscription request.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SubscriptionRequest {
    private Long id;
    private UserRequest user;
    private PlanRequest plan;
    private LocalDateTime start;
    private LocalDateTime finish;
}
