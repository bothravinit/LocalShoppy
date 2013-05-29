package com.localshoppy.api.resource;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteConcern;

@Repository
public class MongoDao {
	private static final Logger logger = LoggerFactory.getLogger(MongoDao.class);

	@Resource
	public MongoTemplate mt;
	
	public MongoDao(){
	}

	public void addDoc(Object obj){
//		mt.save(p);
		
		mt.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		try{
			mt.insert(obj);
		}catch(Exception e){
			logger.info(e.toString());
		}
		
//		mt.update
	}
}
