package es.uned.tw.infrastructure.adapter.outbound.persistence.repository.h2;

import es.uned.tw.application.port.GenrePersistencePort;
import es.uned.tw.domain.model.Genre;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.GenreEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringGenreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The class specific H2 provided implementation as genre repository adapter.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class H2GenreRepositoryAdapter implements GenrePersistencePort {
    private final SpringGenreRepository genreRepository;
    private final GenreEntityMapper genreMapper;

    @Override
    public List<Genre> getGenres() {
        log.info("Listing all genres");
        return this.genreRepository.findAll().stream().
                map(this.genreMapper::toDomain).collect(Collectors.toList());
    }
}
