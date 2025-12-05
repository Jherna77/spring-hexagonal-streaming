package es.uned.tw.application.service;

import es.uned.tw.application.port.*;
import es.uned.tw.domain.exception.ContentException;
import es.uned.tw.domain.model.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The class Content service to manage content operations in application domain.
 */
@Slf4j
@RequiredArgsConstructor
public class ContentService implements ContentServicePort {

    private final ContentPersistencePort contentPersistence;
    private final ContentTypePersistencePort contentTypePersistence;
    private final GenrePersistencePort genrePersistence;
    private final DirectorPersistencePort directorPersistence;
    private final ActorPersistencePort actorPersistence;
    private final SubscriptionPersistencePort subscriptionPersistence;
    private final UserPersistencePort userPersistence;
    private final RatingPersistencePort ratingPersistence;
    private final PlayListPersistencePort playListPersistence;
    private final HistoryPersistencePort historyPersistencePort;

    @Override
    public List<ContentType> getContentTypes() {
        return this.contentTypePersistence.getContentTypes();
    }

    @Override
    public List<ContentType> getContentTypesByUserId(@NonNull final Long userId) throws ContentException {
        final Map<Long, ContentType> groups = new HashMap<>();
        for (final Content content : this.contentPersistence.getContentByFeatureTypes(
                this.subscriptionPersistence.getSubscriptionByUserId(userId).get().
                        getPlan().getFeatures().stream().map(Feature::getId).collect(Collectors.toList()))) {
            groups.putIfAbsent(content.getType().getId(), content.getType());
        }
        log.info("Listing by user {} content types {}", userId, groups.values());
        return new ArrayList<>(groups.values());
    }

    @Override
    public Optional<Content> getContentById(@NonNull final Long id) throws ContentException {
        return this.contentPersistence.getContentById(id);
    }

    @Override
    public List<Content> getContentsByUserId(@NonNull final Long userId) {
        final List<Long> features = this.subscriptionPersistence.getSubscriptionByUserId(userId).get().getPlan().
                getFeatures().stream().map(Feature::getId).collect(Collectors.toList());
        return this.contentPersistence.getContentByFeatureTypes(features);
    }

    @Override
    public List<Content> getContentsRecent(@NonNull final Integer limit) throws ContentException {
        return this.contentPersistence.getContentsOrderAddedDesc().
                stream().limit(limit).collect(Collectors.toList());
    }

    @Override
    public List<Content> getContentsRecentByUserId(@NonNull final Long userId,
                                                   @NonNull final Integer limit) throws ContentException {
        final List<Long> features = this.subscriptionPersistence.getSubscriptionByUserId(userId).get().getPlan().
                getFeatures().stream().map(Feature::getId).collect(Collectors.toList());
        return this.contentPersistence.getContentsOrderByFeatureTypesAddedDesc(features).
                stream().limit(limit).collect(Collectors.toList());
    }

    @Override
    public List<Content> getContentsPreferencesByUserId(
            @NonNull final Long userId) throws ContentException {
        final Optional<User> user = this.userPersistence.getUserById(userId);
        final Optional<Subscription> subscription = this.subscriptionPersistence.getSubscriptionByUserId(userId);
        return this.contentPersistence.getContentByPreferences(
                subscription.get().getPlan().getFeatures().stream().map(Feature::getId).collect(Collectors.toList()),
                user.get().getGenres().stream().map(Genre::getId).collect(Collectors.toList()),
                user.get().getDirectors().stream().map(Director::getId).collect(Collectors.toList()),
                user.get().getActors().stream().map(Actor::getId).collect(Collectors.toList()));
    }

    @Override
    public List<Content> getContents() {
        return this.contentPersistence.getContents();
    }

    @SneakyThrows
    @Override
    public List<Content> getContentsRecommendedByUserId(
            @NonNull Long userId) throws ContentException {
        final Map<Long, Integer> genrePoints = new HashMap<>();
        final Map<Long, Integer> directorPoints = new HashMap<>();
        final Map<Long, Integer> actorPoints = new HashMap<>();

        //Obtiene las preferencias del usuario y sus características suscritas
        final List<Long> features = this.subscriptionPersistence.
                getSubscriptionByUserId(userId).get().getPlan().getFeatures().
                stream().map(Feature::getId).collect(Collectors.toList());

        //Set scores by different preferences, ratings and history
        this.setContentScoreByUserPreferences(userId, genrePoints, directorPoints, actorPoints);
        this.setContentScoreByUserRatings(userId, features, genrePoints, directorPoints, actorPoints);
        final Map<Long, History> userHistory =
                this.setContentScoreByUserHistory(userId, features, genrePoints, directorPoints, actorPoints);
        log.info("Scored recommended to user {} genres {}", userId, genrePoints.entrySet().stream().
                map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.toList()));
        log.info("Scored recommended to user {} directors {}", userId, directorPoints.entrySet().stream().
                map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.toList()));
        log.info("Scored recommended to user {} actors {}", userId, actorPoints.entrySet().stream().
                map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.toList()));

        final Map<Long, Content> result = this.getContentScored(features,
                userHistory, genrePoints, directorPoints, actorPoints);
        final List<Content> sortedContents = result.values().stream().
                sorted(Comparator.comparing(Content::getPoints, Comparator.reverseOrder())).
                limit(20).collect(Collectors.toList());
        log.info("Recommendations for user {} with sorted contents {}", userId, sortedContents.stream().
                map(c -> c.getTitle() + "=" + c.getPoints()).collect(Collectors.toList()));
        return sortedContents;
    }

    private void setContentScoreByUserPreferences(final Long userId,
                                                  final Map<Long, Integer> genrePoints,
                                                  final Map<Long, Integer> directorPoints,
                                                  final Map<Long, Integer> actorPoints) {
        final User user = this.userPersistence.getUserById(userId).get();

        //Set initial score based in user preferences
        this.genrePersistence.getGenres().forEach(g -> genrePoints.put(g.getId(), 0));
        this.directorPersistence.getDirectors().forEach(d -> directorPoints.put(d.getId(), 0));
        this.actorPersistence.getActors().forEach(a -> actorPoints.put(a.getId(), 0));
        user.getGenres().forEach(g -> genrePoints.put(g.getId(), 5));
        user.getDirectors().forEach(d -> directorPoints.put(d.getId(), 5));
        user.getActors().forEach(a -> actorPoints.put(a.getId(), 5));
    }

    private Map<Long, History> setContentScoreByUserHistory(final Long userId, final List<Long> features,
                                                            final Map<Long, Integer> genrePoints,
                                                            final Map<Long, Integer> directorPoints,
                                                            final Map<Long, Integer> actorPoints) {
        final Map<Long, History> userHistory = new HashMap<>();


        //Set accumulated score based in user history for played contents
        for (final History history : this.historyPersistencePort.getHistoryByUserId(userId, features)) {
            userHistory.putIfAbsent(history.getContent().getId(), history);
            log.debug("History content [{}] {}", history.getContent().getTitle(), history);
            history.getContent().getGenres().forEach(g ->
                    genrePoints.put(g.getId(), genrePoints.get(g.getId()) + 1));
            history.getContent().getDirectors().forEach(g ->
                    directorPoints.put(g.getId(), directorPoints.get(g.getId()) + 1));
            history.getContent().getActors().forEach(g ->
                    actorPoints.put(g.getId(), actorPoints.get(g.getId()) + 1));
        }
        return userHistory;
    }

    private void setContentScoreByUserRatings(final Long userId, final List<Long> features,
                                              final Map<Long, Integer> genrePoints,
                                              final Map<Long, Integer> directorPoints,
                                              final Map<Long, Integer> actorPoints) {
        //Set accumulated score based in user ratings for rated contents
        for (final Rating rating : this.ratingPersistence.getRatingByUserId(userId, features)) {
            rating.getContent().getGenres().forEach(g ->
                    genrePoints.put(g.getId(), genrePoints.get(g.getId()) + rating.getRating()));
            rating.getContent().getDirectors().forEach(g ->
                    directorPoints.put(g.getId(), directorPoints.get(g.getId()) + rating.getRating()));
            rating.getContent().getActors().forEach(g ->
                    actorPoints.put(g.getId(), actorPoints.get(g.getId()) + rating.getRating()));
        }
    }

    private Map<Long, Content> getContentScored(final List<Long> features, final Map<Long, History> userHistory,
                                                final Map<Long, Integer> genrePoints,
                                                final Map<Long, Integer> directorPoints,
                                                final Map<Long, Integer> actorPoints) {
        //Retrieve contentes filtered by scored genres, directors or actors
        final List<Content> contents = this.contentPersistence.getContentByPreferences(features,
                genrePoints.entrySet().stream().filter(e -> e.getValue() > 0).
                        map(Map.Entry::getKey).collect(Collectors.toList()),
                directorPoints.entrySet().stream().filter(e -> e.getValue() > 0).
                        map(Map.Entry::getKey).collect(Collectors.toList()),
                actorPoints.entrySet().stream().filter(e -> e.getValue() > 0).
                        map(Map.Entry::getKey).collect(Collectors.toList()));

        //Set final score by content using accumulated scores for each genre, director and actor
        final Map<Long, Content> result = new HashMap<>();
        for (final Content content : contents) {
            if (!result.containsKey(content.getId())) {
                //When content was not played his first score win 100 point to get first positions
                content.setPoints(userHistory.containsKey(content.getId()) ? 0 : 100);
                result.put(content.getId(), content);
            }

            //Establece las puntuaciones acumuladas
            final Content scored = result.get(content.getId());
            scored.getGenres().forEach(c -> scored.setPoints(scored.getPoints() +
                    genrePoints.getOrDefault(c.getId(), 0)));
            scored.getDirectors().forEach(c -> scored.setPoints(scored.getPoints() +
                    directorPoints.getOrDefault(c.getId(), 0)));
            scored.getActors().forEach(c -> scored.setPoints(scored.getPoints() +
                    actorPoints.getOrDefault(c.getId(), 0)));
        }
        return result;
    }

    @Override
    public List<Content> getContentsPlayListByUserId(@NonNull final Long userId) throws ContentException {
        final List<Long> features = this.subscriptionPersistence.
                getSubscriptionByUserId(userId).get().getPlan().getFeatures().
                stream().map(Feature::getId).collect(Collectors.toList());
        final List<PlayList> playLists = this.playListPersistence.getPlayListByUserId(userId);
        return this.contentPersistence.getContentByIds(playLists.stream().
                map(p -> p.getContent().getId()).collect(Collectors.toList()), features);
    }


    @Override
    public void deleteContent(@NonNull final Long id) throws ContentException {
        this.contentPersistence.deleteContentById(id);
    }

    @Override
    public void deleteContents() throws ContentException {
        this.contentPersistence.deleteContents();
    }

    @Override
    public void updateContent(@NonNull final Content content) throws ContentException {
        if (Optional.ofNullable(content.getId()).isEmpty()) {
            content.setAdded(LocalDateTime.now());
            this.contentPersistence.createContent(content);
            return;
        }
        this.contentPersistence.updateContent(content);
    }
}
