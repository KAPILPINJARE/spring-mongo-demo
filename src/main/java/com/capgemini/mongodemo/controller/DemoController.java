package com.capgemini.mongodemo.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@RestController
public class DemoController {
	
	@Autowired
	private GridFsOperations gridFsOperations;
	
	String fileId ="";
	
	@GetMapping("/save")
	public String saveFile() throws FileNotFoundException {
		
		
		DBObject metaData = new BasicDBObject();
		metaData.put("demo", "mongodb");
		InputStream inputStream = new FileInputStream("C:\\Users\\kappawar\\Desktop/demo.mp3");
		metaData.put("type", "audio");		
		
		fileId = gridFsOperations.store(inputStream, "demo.mp3","audio/mp3", metaData).getId().toString();
		
		return "successfully";
		
	}
}
