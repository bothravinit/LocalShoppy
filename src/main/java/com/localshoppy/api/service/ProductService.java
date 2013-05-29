package com.localshoppy.api.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.localshoppy.api.data.model.ProductInfo;

@Service
public class ProductService {

	private static JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		ProductService.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public String addProductIntoDB(ProductInfo product){
		jdbcTemplate.queryForObject("", ProductInfo.class);
		
		return null;
	}
}
