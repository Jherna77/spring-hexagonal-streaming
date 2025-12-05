package es.uned.tw.infrastructure.adapter.outbound.persistence.repository.h2;

import es.uned.tw.application.port.DirectorPersistencePort;
import es.uned.tw.domain.model.Director;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.DirectorEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringDirectorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The class specific H2 provided implementation as director repository adapter.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class H2DirectorRepositoryAdapter implements DirectorPersistencePort {
    private final SpringDirectorRepository directorRepository;
    private final DirectorEntityMapper directorMapper;

    @Override
    public List<Director> getDirectors() {
        log.info("Listing all directors");
        return this.directorRepository.findAll().stream().
                map(this.directorMapper::toDomain).collect(Collectors.toList());
    }
}
