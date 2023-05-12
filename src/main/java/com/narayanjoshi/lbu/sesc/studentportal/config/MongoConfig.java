package com.narayanjoshi.lbu.sesc.studentportal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    public String getDatabaseName() {
        return "studentportaldb";
    }

    // Override other methods if needed

}