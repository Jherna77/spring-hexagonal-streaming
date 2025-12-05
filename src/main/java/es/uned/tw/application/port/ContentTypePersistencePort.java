package es.uned.tw.application.port;

import es.uned.tw.domain.model.ContentType;

import java.util.List;

/**
 * The interface Content type persistence port.
 * It defines all persisten operations to manage content types
 */
public interface ContentTypePersistencePort {
    /**
     * Gets content types.
     *
     * @return the content types
     */
    List<ContentType> getContentTypes();
}