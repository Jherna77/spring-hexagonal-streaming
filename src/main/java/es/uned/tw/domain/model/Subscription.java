package es.uned.tw.domain.model;

import lombok.*;

import java.time.LocalDateTime;

/**
 * The type Subscription.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Subscription {
    private Long id;
    private Plan plan;
    private User user;
    private LocalDateTime start;
    private LocalDateTime finish;
}
