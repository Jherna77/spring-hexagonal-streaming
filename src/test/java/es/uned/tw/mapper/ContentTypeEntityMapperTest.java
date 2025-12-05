package es.uned.tw.mapper;

import es.uned.tw.domain.model.ContentType;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.ContentTypeEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.ContentTypeEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.ContentTypeEntityMapperImpl;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringContentTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Content type entity mapper test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ContentTypeEntityMapperTest {

    private final ContentTypeEntityMapper contentTypeMapper = new ContentTypeEntityMapperImpl();
    @Autowired
    private SpringContentTypeRepository contentTypeRepository;

    /**
     * Test content type entity mapper.
     */
    @Test
    void testContentTypeEntityMapper() {
        final Optional<ContentTypeEntity> contentTypeEntity = this.contentTypeRepository.findById(1L);
        assertThat(contentTypeEntity.get()).isNotNull();
        log.info("ContentType entity: {}", contentTypeEntity.get());

        final ContentType contentType = this.contentTypeMapper.toDomain(contentTypeEntity.get());
        assertThat(contentType).isNotNull();
        assertThat(contentType.getId()).isNotNull();
        assertThat(contentType.getName()).isNotNull();
        assertThat(contentType.getId()).isEqualTo(contentTypeEntity.get().getId());
        assertThat(contentType.getName()).isEqualTo(contentTypeEntity.get().getName());
        log.info("ContentType: {}", contentType);
    }
}