package com.batchsearch.controller;

import com.batchsearch.service.BatchSearchService;
import com.core.model.SearchResult;
import com.core.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@Tag(name = "Search API", description = "API para realizar buscas individuais e em lote")
public class SearchController {
    private final SearchService searchService;
    private final BatchSearchService batchSearchService;

    public SearchController(SearchService searchService, BatchSearchService batchSearchService) {
        this.searchService = searchService;
        this.batchSearchService = batchSearchService;
    }

    @GetMapping("/{query}")
    @Operation(summary = "Realiza uma busca individual", description = "Busca em todas as integracoes disponiveis")
    public List<SearchResult> search(@PathVariable String query) {
        return searchService.search(query);
    }

    @PostMapping("/batch")
    @Operation(summary = "Realiza a busca massiva em paralelo", description = "Executa varias buscas simultaneamente usando processamento assincrno")
    public List<List<SearchResult>> batchSearch(@RequestBody List<String> reservas) {
        return batchSearchService.batchSearch(reservas);
    }
}
