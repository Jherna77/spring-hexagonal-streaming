package es.uned.tw.infrastructure.adapter.outbound.persistence.repository.h2;

import es.uned.tw.application.port.ContentPersistencePort;
import es.uned.tw.domain.exception.ContentException;
import es.uned.tw.domain.model.Content;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.ContentEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.ContentEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringContentRepository;
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
 * The class specific H2 provided implementation as content repository adapter.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class H2ContentRepositoryAdapter implements ContentPersistencePort {
    private final SpringContentRepository contentRepository;
    private final ContentEntityMapper contentMapper;

    @Override
    public Optional<Content> createContent(@NonNull final Content content) {
        final ContentEntity entity = this.contentMapper.fromDomain(content);
        if (Objects.isNull(entity.getId())) {
            entity.setId(this.contentRepository.findTopByOrderByIdDesc().map(e -> e.getId() + 1L).orElse(0L));
        }

        log.info("Creating {}", entity);
        return Optional.ofNullable(this.contentMapper.toDomain(this.contentRepository.save(entity)));
    }

    @Override
    public Optional<Content> getContentById(@NonNull final Long id) {
        log.info("Getting Content(id={})", id);
        return this.contentRepository.findById(id).map(this.contentMapper::toDomain);
    }

    @Override
    public List<Content> getContentByIds(@NonNull final List<Long> ids, @NonNull final List<Long> featureIds) {
        log.info("Getting contents(ids={})", ids);
        return this.contentRepository.findByIdInAndFeatureIdIn(ids, featureIds).stream().
                map(this.contentMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Content> getContentByFeatureTypes(@NonNull final List<Long> featureIds) {
        log.info("Getting contents by FeatureTypes(ids={})", featureIds);
        return this.contentRepository.findByFeatureIdIn(featureIds).stream().
                map(this.contentMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Content> getContentByPreferences(@NonNull final List<Long> featureIds,
                                                 @NonNull final List<Long> genreIds,
                                                 @NonNull final List<Long> directorIds,
                                                 @NonNull final List<Long> actorIds) {
        log.info("Getting contents by Genres(ids={}) Directors(ids={}) Actors(ids={})",
                genreIds, directorIds, actorIds);
        return this.contentMapper.toDomain(this.contentRepository.
                findDistinctByGenresIdInOrDirectorsIdInOrActorsIdInOrderByAddedDesc(
                        genreIds, directorIds, actorIds).stream().
                filter(c -> featureIds.contains(c.getFeature().getId())).collect(Collectors.toList()));
    }

    @Override
    public List<Content> getContents() {
        log.info("Listing all contents");
        return this.contentRepository.findAll().stream().
                map(this.contentMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Content> getContentsOrderAddedDesc() {
        log.info("Listing contents order added desc");
        return this.contentRepository.findAllByOrderByAddedDesc().stream().
                map(this.contentMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Content> getContentsOrderByFeatureTypesAddedDesc(@NonNull final List<Long> featureIds) {
        log.info("Listing contents order added desc by FeatureTypes(ids={})", featureIds);
        return this.contentRepository.findAllByOrderByAddedDesc().stream().
                filter(c -> featureIds.contains(c.getFeature().getId())).
                map(this.contentMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Content> updateContent(@NonNull final Content content) {
        return Optional.ofNullable(this.contentMapper.toDomain(
                this.contentRepository.save(this.contentMapper.fromDomain(content))));
    }

    @Override
    public void deleteContentById(@NonNull final Long id) throws ContentException {
        log.info("Deleting Content(id={})", id);
        this.contentRepository.deleteById(id);
    }

    @Override
    public void deleteContents() throws ContentException {
        log.info("Deleting all contents");
        this.contentRepository.deleteAll();
    }
}
