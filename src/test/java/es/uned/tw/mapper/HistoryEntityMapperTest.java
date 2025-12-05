package es.uned.tw.mapper;

import es.uned.tw.domain.model.History;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.HistoryEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.*;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type History entity mapper test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class HistoryEntityMapperTest {
    private final HistoryEntityMapper historyMapper = new HistoryEntityMapperImpl(
            new UserEntityMapperImpl(
                    new RoleEntityMapperImpl(), new GenreEntityMapperImpl(),
                    new DirectorEntityMapperImpl(), new ActorEntityMapperImpl()),
            new ContentEntityMapperImpl(
                    new ContentTypeEntityMapperImpl(), new FeatureEntityMapperImpl(),
                    new GenreEntityMapperImpl(), new DirectorEntityMapperImpl(),
                    new ActorEntityMapperImpl()));
    @Autowired
    private SpringHistoryRepository historyRepository;

    /**
     * Test history entity mapper.
     */
    @Test
    void testHistoryEntityMapper() {
        final Optional<HistoryEntity> historyEntity = this.historyRepository.findById(1L);
        assertThat(historyEntity.get()).isNotNull();
        log.info("History entity: {}", historyEntity.get());
        log.info("History entity user: {}", historyEntity.get().getUser());
        log.info("History entity content: {}", historyEntity.get().getContent());

        final History history = this.historyMapper.toDomain(historyEntity.get());
        assertThat(history).isNotNull();
        assertThat(history.getDate()).isNotNull();
        assertThat(history.getDate()).isEqualTo(historyEntity.get().getDate());
        log.info("History: {}", history);

        assertThat(history.getContent()).isNotNull();
        assertThat(history.getContent().getId()).isEqualTo(historyEntity.get().getContent().getId());
        log.info("History content: {}", history.getContent());

        assertThat(history.getUser()).isNotNull();
        assertThat(history.getUser().getId()).isEqualTo(historyEntity.get().getUser().getId());
        log.info("History user: {}", history.getUser());
    }
}