package es.uned.tw.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.RatingEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.UserContentPK;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringRatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Rating repository test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RatingRepositoryTest {
    @Autowired
    private SpringRatingRepository ratingRepository;

    /**
     * Test all ratings.
     */
    @Test
    void testAllRatings() {
        final List<RatingEntity> ratings = this.ratingRepository.findAll();
        assertThat(ratings).isNotNull();
        log.info("Ratings: {}", ratings);
    }

    /**
     * Test rating with user id 3 and content id 1.
     */
    @Test
    void testRatingWithUserId3AndContentId1() {
        final Optional<RatingEntity> rating = this.ratingRepository.findById(new UserContentPK(3L, 1L));
        assertThat(rating.get()).isNotNull();
        assertThat(rating.get().getRating()).isNotNull();
        assertThat(rating.get().getDate()).isNotNull();
        log.info("Rating: {}", rating.get());

        assertThat(rating.get().getUser()).isNotNull();
        log.info("Rating user: {}", rating.get().getUser());

        assertThat(rating.get().getContent()).isNotNull();
        log.info("Rating content: {}", rating.get().getContent());
    }
}
