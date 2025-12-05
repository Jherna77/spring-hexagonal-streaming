package es.uned.tw.infrastructure.adapter.inbound.presenter;

import es.uned.tw.application.port.ContentServicePort;
import es.uned.tw.application.port.HistoryServicePort;
import es.uned.tw.application.port.RatingServicePort;
import es.uned.tw.domain.model.Content;
import es.uned.tw.domain.model.History;
import es.uned.tw.domain.model.Rating;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.ContentRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.HistoryRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.RatingRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.ChartRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * The class Admin statistics controller.
 */
@Slf4j
@Controller
@RequestMapping({"/admin-statistics"})
@RequiredArgsConstructor
public class AdminStatisticsController {

    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private final RatingServicePort ratingService;
    private final RatingRestMapper ratingMapper;
    private final HistoryServicePort historyService;
    private final HistoryRestMapper historyMapper;
    private final ContentServicePort contentService;
    private final ContentRestMapper contentMapper;

    /**
     * Get statistics charts aggregating in model all types with data
     *
     * @param model the model
     * @return the template name
     */
    @SneakyThrows
    @GetMapping
    public String statistics(final Model model) {
        final List<ChartRequest> charts = List.of(this.getChartContentsRating(),
                this.getChartContentPlayed(), this.getChartContentType());
        model.addAttribute("charts", charts);
        model.addAttribute("history",
                this.historyMapper.fromDomain(this.historyService.getHistory()));
        model.addAttribute("ratings",
                this.ratingMapper.fromDomain(this.ratingService.getRatings()));
        return "admin/admin-statistics";
    }

    @SneakyThrows
    private ChartRequest getChartContentsRating() {
        final Map<String, Integer> ratings = new HashMap<>();
        for (final Rating rate : this.ratingService.getRatings()) {
            ratings.putIfAbsent(rate.getContent().getTitle(), 0);
            ratings.put(rate.getContent().getTitle(),
                    ratings.get(rate.getContent().getTitle()) + rate.getRating());
        }

        return this.getChart("chart-content-rating", "chart.content.rate.title", ratings,
                "Contenido", "Puntuación");
    }

    @SneakyThrows
    private ChartRequest getChartContentPlayed() {
        final Map<String, Integer> plays = new HashMap<>();
        for (final History play : this.historyService.getHistory()) {
            plays.putIfAbsent(play.getContent().getTitle(), 0);
            plays.put(play.getContent().getTitle(),
                    plays.get(play.getContent().getTitle()) + 1);
        }

        return this.getChart("chart-content-played", "chart.content.play.title", plays,
                "Contenido", "Reproducciones");
    }

    private ChartRequest getChartContentType() {
        final Map<String, Integer> contents = new HashMap<>();
        for (final Content content : this.contentService.getContents()) {
            contents.putIfAbsent(content.getType().getName(), 0);
            contents.put(content.getType().getName(),
                    contents.get(content.getType().getName()) + 1);
        }

        return this.getChart("chart-content-type", "chart.content.type.title", contents,
                "Tipo", "Contenidos");
    }

    private ChartRequest getChart(final String id, final String title, final Map<String, Integer> values,
                                  final String pivotName, final String valueName) {
        final ChartRequest chartRequest = new ChartRequest();
        chartRequest.setId(id);
        chartRequest.setTitle(title);
        chartRequest.setRows(new ArrayList<>());
        values.forEach((key, value) -> chartRequest.getRows().add(List.of(key, value)));
        chartRequest.setCols(new LinkedHashMap<>());
        chartRequest.getCols().put("string", pivotName);
        chartRequest.getCols().put("number", valueName);
        return chartRequest;
    }
}