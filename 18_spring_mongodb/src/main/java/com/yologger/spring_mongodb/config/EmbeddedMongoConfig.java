package com.yologger.spring_mongodb.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration
@Profile("local")
public class EmbeddedMongoConfig {
    @Value("${spring.data.mongodb.host}") private String host;
    @Value("${spring.data.mongodb.port}") private int port;

    private MongodStarter mongodStarter;
    private MongodProcess mongodProcess;
    private MongodExecutable mongodExecutable;

    @PostConstruct
    void startMongod() throws IOException {
        MongodConfig config = MongodConfig.builder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(host, port, Network.localhostIsIPv6()))
                .build();
        mongodStarter = MongodStarter.getDefaultInstance();
        mongodExecutable = mongodStarter.prepare(config);
        mongodProcess = mongodExecutable.start();
    }

    @PreDestroy
    void stopMongod() {
        mongodProcess.stop();
        mongodExecutable.stop();
    }

    @Bean
    MongoClient mongoClient() {
        return MongoClients.create("mongodb://" + host + ":" + port);
    }
}
