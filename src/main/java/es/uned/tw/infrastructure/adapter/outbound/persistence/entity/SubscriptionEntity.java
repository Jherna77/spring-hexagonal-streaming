package es.uned.tw.infrastructure.adapter.outbound.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The type Subscription entity.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "subscriptions")
public class SubscriptionEntity {
    @Id
    private Long id;
    @OneToOne
    private PlanEntity plan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity user;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime start;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime finish;
}
