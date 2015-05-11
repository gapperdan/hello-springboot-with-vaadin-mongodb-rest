package com.gapperdan.hsvmr.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${mongo.database}")
    private String databaseName;

    @Value("${mongo.host}")
    private String host;

    @Value("${mongo.port}")
    private int port;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(host, port);
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.gapperdan.hsvmr";
    }
}
