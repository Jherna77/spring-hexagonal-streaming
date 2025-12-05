package es.uned.tw.mapper;

import es.uned.tw.domain.model.Rating;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.RatingEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.UserContentPK;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.*;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringRatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Rating entity mapper test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RatingEntityMapperTest {
    private final RatingEntityMapper ratingMapper = new RatingEntityMapperImpl(
            new UserEntityMapperImpl(
                    new RoleEntityMapperImpl(), new GenreEntityMapperImpl(),
                    new DirectorEntityMapperImpl(), new ActorEntityMapperImpl()),
            new ContentEntityMapperImpl(
                    new ContentTypeEntityMapperImpl(), new FeatureEntityMapperImpl(),
                    new GenreEntityMapperImpl(), new DirectorEntityMapperImpl(),
                    new ActorEntityMapperImpl()));
    @Autowired
    private SpringRatingRepository ratingRepository;

    /**
     * Test rating entity mapper.
     */
    @Test
    void testRatingEntityMapper() {
        final Optional<RatingEntity> ratingEntity = this.ratingRepository.findById(new UserContentPK(3L, 1L));
        assertThat(ratingEntity.get()).isNotNull();
        log.info("Rating entity: {}", ratingEntity.get());
        log.info("Rating entity user: {}", ratingEntity.get().getUser());
        log.info("Rating entity content: {}", ratingEntity.get().getContent());

        final Rating rating = this.ratingMapper.toDomain(ratingEntity.get());
        assertThat(rating).isNotNull();
        assertThat(rating.getRating()).isNotNull();
        assertThat(rating.getDate()).isNotNull();
        assertThat(rating.getRating()).isEqualTo(ratingEntity.get().getRating());
        assertThat(rating.getDate()).isEqualTo(ratingEntity.get().getDate());
        log.info("Rating: {}", rating);

        assertThat(rating.getContent()).isNotNull();
        assertThat(rating.getContent().getId()).isEqualTo(ratingEntity.get().getContent().getId());
        log.info("Rating content: {}", rating.getContent());

        assertThat(rating.getUser()).isNotNull();
        assertThat(rating.getUser().getId()).isEqualTo(ratingEntity.get().getUser().getId());
        log.info("Rating user: {}", rating.getUser());
    }
}
