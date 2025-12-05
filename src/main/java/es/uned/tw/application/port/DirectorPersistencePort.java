package es.uned.tw.application.port;

import es.uned.tw.domain.model.Director;

import java.util.List;

/**
 * The interface Director persistence port.
 * It defines all persisten operations to manage directors
 */
public interface DirectorPersistencePort {
    /**
     * Gets directors.
     *
     * @return the directors
     */
    List<Director> getDirectors();
}
