package com.yologger.samples.spring_elastic_search;

import com.yologger.samples.spring_elastic_search.repository.PlayerDocument;
import com.yologger.samples.spring_elastic_search.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.test.annotation.Commit;

import javax.swing.text.Document;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private ElasticsearchOperations operations;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void test_save() {
        PlayerDocument player = PlayerDocument.builder()
                .name("neymar")
                .nation("brazil")
                .age(31)
                .score(34)
                .assist(40)
                .build();

        operations.save(player);
    }

    @Test
    void test1() {
        PlayerDocument player = PlayerDocument.builder()
                .name("figo")
                .nation("portugal")
                .age(45)
                .score(34)
                .assist(40)
                .build();

        PlayerDocument saved = playerRepository.save(player);

        assertThat(saved.getName()).isEqualTo("figo");
    }
}
