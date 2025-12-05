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
 * The type Rating entity.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "ratings")
@IdClass(UserContentPK.class)
public class RatingEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ContentEntity content;

    private Integer rating;
    @Column(name = "rating_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime date;
}
