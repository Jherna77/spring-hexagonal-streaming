package es.uned.tw.application.service;

import es.uned.tw.application.port.*;
import es.uned.tw.domain.exception.BackupException;
import es.uned.tw.domain.model.Backup;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The class Backup service to manage backup operations in application domain.
 */
@Slf4j
@RequiredArgsConstructor
public class BackupService implements BackupServicePort {
    private final UserPersistencePort userPersistence;
    private final GenrePersistencePort genrePersistencePort;
    private final DirectorPersistencePort directorPersistencePort;
    private final ActorPersistencePort actorPersistencePort;
    private final ContentTypePersistencePort contentTypePersistence;
    private final FeaturePersistencePort featurePersistencePort;
    private final PlanPersistencePort planPersistence;
    private final ContentPersistencePort contentPersistence;
    private final SubscriptionPersistencePort subscriptionPersistence;
    private final RatingPersistencePort ratingPersistence;
    private final PlayListPersistencePort playListPersistence;
    private final HistoryPersistencePort historyPersistence;

    private final AtomicLong idBackup = new AtomicLong(0);
    private final Map<Long, Backup> backups = new LinkedHashMap<>();

    /**
     * Init service called from post construct to initialize a default backup
     */
    @SneakyThrows
    @PostConstruct
    public void init() {
        //Create a default backup
        this.performBackup("SYSTEM");
    }

    @Override
    public Optional<Backup> getBackup(@NonNull final Long id) throws BackupException {
        return Optional.ofNullable(this.backups.get(id));
    }

    @Override
    public List<Backup> getBackups() {
        return new ArrayList<>(this.backups.values());
    }

    @Override
    public void performBackup(final String user) throws BackupException {
        final Backup backup = Backup.builder().id(this.idBackup.incrementAndGet()).
                user(user).perform(LocalDateTime.now()).
                users(this.userPersistence.getUsers()).
                genres(this.genrePersistencePort.getGenres()).
                directors(this.directorPersistencePort.getDirectors()).
                actors(this.actorPersistencePort.getActors()).
                contentTypes(this.contentTypePersistence.getContentTypes()).
                features(this.featurePersistencePort.getFeatures()).
                plans(this.planPersistence.getPlans()).
                contents(this.contentPersistence.getContents()).
                ratings(this.ratingPersistence.getRatings()).
                subscriptions(this.subscriptionPersistence.getSubscriptions()).
                playlists(this.playListPersistence.getPlayLists()).
                histories(this.historyPersistence.getHistories()).
                build();
        this.backups.put(backup.getId(), backup);
        log.info("Performing backup {}}", backup);
    }

    @Override
    public void restoreBackup(@NonNull final Long id) throws BackupException {
        final Optional<Backup> backup = this.getBackup(id);
        if (backup.isPresent()) {
            log.info("Restoring backup id {}", id);
            this.removePersistenceData();
            this.savePersistenceData(backup.get());

            //Establece la fecha de recuperación
            backup.get().setRestore(LocalDateTime.now());
        } else {
            log.error("Cannot restore not existing backup id {}", id);
            throw new BackupException();
        }
    }

    @Override
    public void deleteBackup(@NonNull final Long id) throws BackupException {
        log.info("Deleting backup id {}", id);
        this.backups.remove(id);
    }

    @Override
    public void deleteBackups() throws BackupException {
        log.info("Deleting all backups");
        this.backups.clear();
    }

    @SneakyThrows
    private void removePersistenceData() {
        this.userPersistence.deleteUsers();
        this.contentPersistence.deleteContents();
    }

    private void savePersistenceData(@NonNull final Backup backup) {
        backup.getUsers().forEach(this.userPersistence::createUser);
        backup.getSubscriptions().forEach(this.subscriptionPersistence::createSubscription);
        backup.getContents().forEach(this.contentPersistence::createContent);
        backup.getRatings().forEach(this.ratingPersistence::createRating);
        backup.getPlaylists().forEach(this.playListPersistence::createPlayList);
        backup.getHistories().forEach(this.historyPersistence::createHistory);
    }
}
