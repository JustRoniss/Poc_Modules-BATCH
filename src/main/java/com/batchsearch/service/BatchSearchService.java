package com.batchsearch.service;

import com.core.model.SearchResult;
import com.core.service.SearchService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class BatchSearchService {
    private final SearchService searchService;

    public BatchSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    @Async("searchTaskExecutor")
    public CompletableFuture<List<SearchResult>> searchAsync(String query){
        return CompletableFuture.completedFuture(searchService.search(query));
    }

    public List<List<SearchResult>> batchSearch(List<String> queries){
        var futures = queries.stream()
                .map(this::searchAsync)
                .toList();

        return futures.stream()
                .map(CompletableFuture::join)
                .toList();
    }
}
