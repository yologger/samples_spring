package com.yologger.samples.spring_elastic_search.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PlayerRepository extends ElasticsearchRepository<PlayerDocument, String>, CustomPlayerRepository {
}
