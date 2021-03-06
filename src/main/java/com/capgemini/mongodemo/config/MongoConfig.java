package com.capgemini.mongodemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class MongoConfig extends AbstractMongoConfiguration{
	
	@Value("$(spring.data.mongodb.host)")
	private String host;
	
	@Value("$(spring.data.mongodb.databases)")
	private String databases;

	@Override
	protected String getDatabaseName() {
		return databases;
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(host);
	}
	
	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
		return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}
}
