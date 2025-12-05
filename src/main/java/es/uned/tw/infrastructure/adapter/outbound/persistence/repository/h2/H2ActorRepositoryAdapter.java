package es.uned.tw.infrastructure.adapter.outbound.persistence.repository.h2;

import es.uned.tw.application.port.ActorPersistencePort;
import es.uned.tw.domain.model.Actor;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.ActorEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringActorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The class specific H2 provided implementation as actor repository adapter.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class H2ActorRepositoryAdapter implements ActorPersistencePort {
    private final SpringActorRepository actorRepository;
    private final ActorEntityMapper actorMapper;

    @Override
    public List<Actor> getActors() {
        log.info("Listing all actors");
        return this.actorRepository.findAll().stream().
                map(this.actorMapper::toDomain).collect(Collectors.toList());
    }
}
