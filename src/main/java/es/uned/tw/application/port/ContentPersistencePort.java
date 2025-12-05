package es.uned.tw.application.port;

import es.uned.tw.domain.exception.ContentException;
import es.uned.tw.domain.model.Content;

import java.util.List;
import java.util.Optional;

/**
 * The interface Content persistence port.
 * It defines all persisten operations to manage contents
 */
public interface ContentPersistencePort {
    /**
     * Create content optional.
     *
     * @param content the content
     * @return the optional
     */
    Optional<Content> createContent(final Content content);

    /**
     * Gets content by id.
     *
     * @param id the id
     * @return the content by id
     */
    Optional<Content> getContentById(final Long id);

    /**
     * Gets content by ids.
     *
     * @param ids        the ids
     * @param featureIds the feature ids
     * @return the content by ids
     */
    List<Content> getContentByIds(final List<Long> ids, final List<Long> featureIds);

    /**
     * Gets content by feature types.
     *
     * @param featureIds the feature ids
     * @return the content by feature types
     */
    List<Content> getContentByFeatureTypes(final List<Long> featureIds);

    /**
     * Gets content by preferences.
     *
     * @param featureIds  the feature ids
     * @param genreIds    the genre ids
     * @param directorIds the director ids
     * @param actorIds    the actor ids
     * @return the content by preferences
     */
    List<Content> getContentByPreferences(final List<Long> featureIds,
                                          final List<Long> genreIds,
                                          final List<Long> directorIds,
                                          final List<Long> actorIds);

    /**
     * Gets contents.
     *
     * @return the contents
     */
    List<Content> getContents();

    /**
     * Gets contents order added desc.
     *
     * @return the contents order added desc
     */
    List<Content> getContentsOrderAddedDesc();

    /**
     * Gets contents order by feature types added desc.
     *
     * @param featureIds the feature ids
     * @return the contents order by feature types added desc
     */
    List<Content> getContentsOrderByFeatureTypesAddedDesc(final List<Long> featureIds);

    /**
     * Update content optional.
     *
     * @param content the content
     * @return the optional
     */
    Optional<Content> updateContent(final Content content);

    /**
     * Delete content by id.
     *
     * @param id the id
     * @throws ContentException the content exception
     */
    void deleteContentById(final Long id) throws ContentException;

    /**
     * Delete contents.
     *
     * @throws ContentException the content exception
     */
    void deleteContents() throws ContentException;
}
