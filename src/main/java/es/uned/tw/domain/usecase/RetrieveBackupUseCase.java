package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.BackupException;
import es.uned.tw.domain.model.Backup;

import java.util.List;
import java.util.Optional;

/**
 * The interface Retrieve backup use case.
 */
public interface RetrieveBackupUseCase {
    /**
     * Gets backup.
     *
     * @param id the id
     * @return the backup
     * @throws BackupException the backup exception
     */
    Optional<Backup> getBackup(final Long id) throws BackupException;

    /**
     * Gets backups.
     *
     * @return the backups
     */
    List<Backup> getBackups();
}
