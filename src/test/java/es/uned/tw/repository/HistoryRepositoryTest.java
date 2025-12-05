package es.uned.tw.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.HistoryEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringHistoryRepository;
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
 * The type History repository test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class HistoryRepositoryTest {
    @Autowired
    private SpringHistoryRepository historyRepository;

    /**
     * Tes all histories.
     */
    @Test
    void tesAllHistories() {
        final List<HistoryEntity> histories = this.historyRepository.findAll();
        assertThat(histories).isNotNull();
        log.info("Histories: {}", histories);
    }

    /**
     * Test history with id 1.
     */
    @Test
    void testHistoryWithId1() {
        final Optional<HistoryEntity> history = this.historyRepository.findById(1L);
        assertThat(history.get()).isNotNull();
        assertThat(history.get().getDate()).isNotNull();
        log.info("History: {}", history.get());

        assertThat(history.get().getUser()).isNotNull();
        log.info("History user: {}", history.get().getUser());

        assertThat(history.get().getContent()).isNotNull();
        log.info("History content: {}", history.get().getContent());
    }
}