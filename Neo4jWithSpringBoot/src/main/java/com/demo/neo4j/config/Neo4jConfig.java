package com.demo.neo4j.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.demo.neo4j.repository")
@EnableTransactionManagement
public class Neo4jConfig {

	@Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), "com.demo.neo4j.model");
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
    	org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
    	.uri("bolt://localhost:7687")
    	.credentials("neo4j", "password")
    	.autoIndex("none")
        .build();
    	return configuration;
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}
