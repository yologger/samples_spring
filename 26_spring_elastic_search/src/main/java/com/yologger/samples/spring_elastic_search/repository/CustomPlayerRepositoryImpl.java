package com.yologger.samples.spring_elastic_search.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CustomPlayerRepositoryImpl implements CustomPlayerRepository {

    private final ElasticsearchOperations elasticsearchOperations;

    @Override
    public List<PlayerDocument> searchByNation(String name) {
        // ...
    }
}
