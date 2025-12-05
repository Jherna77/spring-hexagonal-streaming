package es.uned.tw.infrastructure.adapter.outbound.persistence.repository.h2;

import es.uned.tw.application.port.HistoryPersistencePort;
import es.uned.tw.domain.model.History;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.HistoryEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.HistoryEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringHistoryRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The class specific H2 provided implementation as history repository adapter.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class H2HistoryRepositoryAdapter implements HistoryPersistencePort {

    private final SpringHistoryRepository historyRepository;
    private final HistoryEntityMapper historyMapper;

    @Override
    public Optional<History> createHistory(@NonNull final History history) {
        final HistoryEntity entity = this.historyMapper.fromDomain(history);
        if (Objects.isNull(entity.getId())) {
            entity.setId(this.historyRepository.findTopByOrderByIdDesc().map(e -> e.getId() + 1L).orElse(0L));
        }

        log.info("Creating {}", entity);
        return Optional.ofNullable(this.historyMapper.toDomain(this.historyRepository.save(entity)));
    }

    @Override
    public List<History> getHistoryByUserId(@NonNull final Long userId, @NonNull final List<Long> featureIds) {
        log.info("Getting histories by User(id={})", userId);
        return this.historyMapper.toDomain(this.historyRepository.findDistinctByUserIdOrderByDateDesc(userId)).
                stream().filter(r -> featureIds.contains(r.getContent().getFeature().getId())).
                collect(Collectors.toList());
    }

    @Override
    public Long countHistoryByContentIdAndUserId(@NonNull final Long userId, @NonNull final Long contentId) {
        log.info("Getting rating by User(id={}) Content(id={})", userId, contentId);
        return this.historyRepository.countByUserIdAndContentId(userId, contentId);
    }

    @Override
    public List<History> getHistories() {
        log.info("Listing all histories");
        return this.historyRepository.findAll().stream().
                map(this.historyMapper::toDomain).collect(Collectors.toList());
    }
}
