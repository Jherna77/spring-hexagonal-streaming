package es.uned.tw.infrastructure.configuration;

import es.uned.tw.application.port.*;
import es.uned.tw.application.service.*;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.UserRequest;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.h2.H2UserRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;

/**
 * The class Bean configuration to define all dependencies necessaries to allow
 * application the Inversión of Control injecting dependencies from infrastructure layer
 */
@Configuration
public class BeanConfiguration {
    /**
     * User request user request.
     *
     * @return the user request
     */
    @Bean
    @SessionScope
    public UserRequest userRequest() {
        final UserRequest userRequest = new UserRequest();
        userRequest.setGenres(new ArrayList<>());
        userRequest.setDirectors(new ArrayList<>());
        userRequest.setActors(new ArrayList<>());
        return userRequest;
    }

    /**
     * User service port user service port.
     *
     * @param userPersistencePort the user persistence port
     * @param passwordEncoder     the password encoder
     * @return the user service port
     */
    @Bean
    public UserServicePort userServicePort(final H2UserRepositoryAdapter userPersistencePort,
                                           final BCryptPasswordEncoder passwordEncoder) {
        return new UserService(userPersistencePort, passwordEncoder);
    }

    /**
     * Preferences service port preferences service port.
     *
     * @param genrePersistencePort    the genre persistence port
     * @param directorPersistencePort the director persistence port
     * @param actorPersistencePort    the actor persistence port
     * @return the preferences service port
     */
    @Bean
    public PreferencesServicePort preferencesServicePort(final GenrePersistencePort genrePersistencePort,
                                                         final DirectorPersistencePort directorPersistencePort,
                                                         final ActorPersistencePort actorPersistencePort) {
        return new PreferencesService(genrePersistencePort, directorPersistencePort, actorPersistencePort);
    }

    /**
     * Plan service port plan service port.
     *
     * @param planPersistencePort the plan persistence port
     * @return the plan service port
     */
    @Bean
    public PlanServicePort planServicePort(final PlanPersistencePort planPersistencePort) {
        return new PlanService(planPersistencePort);
    }

    /**
     * Feature service port feature service port.
     *
     * @param featurePersistencePort the feature persistence port
     * @return the feature service port
     */
    @Bean
    public FeatureServicePort featureServicePort(final FeaturePersistencePort featurePersistencePort) {
        return new FeatureService(featurePersistencePort);
    }

    /**
     * Subscription service port subscription service port.
     *
     * @param subscriptionPersistencePort the subscription persistence port
     * @param userPersistencePort         the user persistence port
     * @param planPersistencePort         the plan persistence port
     * @return the subscription service port
     */
    @Bean
    public SubscriptionServicePort subscriptionServicePort(
            final SubscriptionPersistencePort subscriptionPersistencePort,
            final UserPersistencePort userPersistencePort,
            final PlanPersistencePort planPersistencePort) {
        return new SubscriptionService(subscriptionPersistencePort, userPersistencePort, planPersistencePort);
    }

    /**
     * Content service port content service port.
     *
     * @param contentPersistencePort      the content persistence port
     * @param contentTypePersistencePort  the content type persistence port
     * @param genrePersistencePort        the genre persistence port
     * @param directorPersistencePort     the director persistence port
     * @param actorPersistencePort        the actor persistence port
     * @param subscriptionPersistencePort the subscription persistence port
     * @param userPersistencePort         the user persistence port
     * @param ratingPersistencePort       the rating persistence port
     * @param playListPersistencePort     the play list persistence port
     * @param historyPersistencePort      the history persistence port
     * @return the content service port
     */
    @Bean
    public ContentServicePort contentServicePort(
            final ContentPersistencePort contentPersistencePort,
            final ContentTypePersistencePort contentTypePersistencePort,
            final GenrePersistencePort genrePersistencePort,
            final DirectorPersistencePort directorPersistencePort,
            final ActorPersistencePort actorPersistencePort,
            final SubscriptionPersistencePort subscriptionPersistencePort,
            final UserPersistencePort userPersistencePort,
            final RatingPersistencePort ratingPersistencePort,
            final PlayListPersistencePort playListPersistencePort,
            final HistoryPersistencePort historyPersistencePort) {
        return new ContentService(contentPersistencePort, contentTypePersistencePort,
                genrePersistencePort, directorPersistencePort, actorPersistencePort,
                subscriptionPersistencePort, userPersistencePort, ratingPersistencePort,
                playListPersistencePort, historyPersistencePort);
    }

    /**
     * History service port history service port.
     *
     * @param historyPersistencePort the history persistence port
     * @param userPersistencePort    the user persistence port
     * @param contentPersistencePort the content persistence port
     * @return the history service port
     */
    @Bean
    public HistoryServicePort historyServicePort(
            final HistoryPersistencePort historyPersistencePort,
            final UserPersistencePort userPersistencePort,
            final ContentPersistencePort contentPersistencePort) {
        return new HistoryService(historyPersistencePort, userPersistencePort,
                contentPersistencePort);
    }

    /**
     * Rating service port rating service port.
     *
     * @param ratingPersistencePort  the rating persistence port
     * @param userPersistencePort    the user persistence port
     * @param contentPersistencePort the content persistence port
     * @return the rating service port
     */
    @Bean
    public RatingServicePort ratingServicePort(
            final RatingPersistencePort ratingPersistencePort,
            final UserPersistencePort userPersistencePort,
            final ContentPersistencePort contentPersistencePort) {
        return new RatingService(ratingPersistencePort, userPersistencePort,
                contentPersistencePort);
    }

    /**
     * Play list service port play list service port.
     *
     * @param playListPersistencePort the play list persistence port
     * @param userPersistencePort     the user persistence port
     * @param contentPersistencePort  the content persistence port
     * @return the play list service port
     */
    @Bean
    public PlayListServicePort playListServicePort(
            final PlayListPersistencePort playListPersistencePort,
            final UserPersistencePort userPersistencePort,
            final ContentPersistencePort contentPersistencePort) {
        return new PlayListService(playListPersistencePort, userPersistencePort, contentPersistencePort);
    }

    /**
     * Backup service port backup service port.
     *
     * @param userPersistencePort         the user persistence port
     * @param genrePersistencePort        the genre persistence port
     * @param directorPersistencePort     the director persistence port
     * @param actorPersistencePort        the actor persistence port
     * @param contentTypePersistencePort  the content type persistence port
     * @param featurePersistencePort      the feature persistence port
     * @param planPersistencePort         the plan persistence port
     * @param contentPersistencePort      the content persistence port
     * @param subscriptionPersistencePort the subscription persistence port
     * @param ratingPersistencePort       the rating persistence port
     * @param playListPersistencePort     the play list persistence port
     * @param historyPersistencePort      the history persistence port
     * @return the backup service port
     */
    @Bean
    public BackupServicePort backupServicePort(
            final UserPersistencePort userPersistencePort,
            final GenrePersistencePort genrePersistencePort,
            final DirectorPersistencePort directorPersistencePort,
            final ActorPersistencePort actorPersistencePort,
            final ContentTypePersistencePort contentTypePersistencePort,
            final FeaturePersistencePort featurePersistencePort,
            final PlanPersistencePort planPersistencePort,
            final ContentPersistencePort contentPersistencePort,
            final SubscriptionPersistencePort subscriptionPersistencePort,
            final RatingPersistencePort ratingPersistencePort,
            final PlayListPersistencePort playListPersistencePort,
            final HistoryPersistencePort historyPersistencePort) {
        return new BackupService(userPersistencePort,
                genrePersistencePort, directorPersistencePort, actorPersistencePort,
                contentTypePersistencePort, featurePersistencePort, planPersistencePort,
                contentPersistencePort, subscriptionPersistencePort, ratingPersistencePort,
                playListPersistencePort, historyPersistencePort);
    }
}
