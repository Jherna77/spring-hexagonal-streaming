package es.uned.tw.application.port;

import es.uned.tw.domain.usecase.DeleteBackupUseCase;
import es.uned.tw.domain.usecase.PerformBackupUseCase;
import es.uned.tw.domain.usecase.RestoreBackupUseCase;
import es.uned.tw.domain.usecase.RetrieveBackupUseCase;

/**
 * The interface Backup service port.
 * It extends to implements all use cases related with backup operations
 */
public interface BackupServicePort extends PerformBackupUseCase,
        RetrieveBackupUseCase, RestoreBackupUseCase, DeleteBackupUseCase {
}
