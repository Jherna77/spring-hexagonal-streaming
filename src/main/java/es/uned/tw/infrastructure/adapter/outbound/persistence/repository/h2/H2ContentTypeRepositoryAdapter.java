package es.uned.tw.infrastructure.adapter.outbound.persistence.repository.h2;

import es.uned.tw.application.port.ContentTypePersistencePort;
import es.uned.tw.domain.model.ContentType;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.ContentTypeEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringContentTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The class specific H2 provided implementation as content type repository adapter.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class H2ContentTypeRepositoryAdapter implements ContentTypePersistencePort {
    private final SpringContentTypeRepository contentTypeRepository;
    private final ContentTypeEntityMapper contentTypeMapper;

    @Override
    public List<ContentType> getContentTypes() {
        log.info("Listing all types of content");
        return this.contentTypeRepository.findAll().stream().
                map(this.contentTypeMapper::toDomain).collect(Collectors.toList());

    }

}
