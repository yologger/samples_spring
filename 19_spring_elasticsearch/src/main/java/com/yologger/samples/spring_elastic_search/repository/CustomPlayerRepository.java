package com.yologger.samples.spring_elastic_search.repository;

import java.util.List;

public interface CustomPlayerRepository {
    List<PlayerDocument> searchByNation(String name);
}
