package com.localshoppy.api.service;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;

import com.localshoppy.api.data.model.ProductInfo;

public interface ProductRepository extends Repository<ProductInfo, Long> {

	public long count();

	public ProductInfo findById(String id);

	@Query(fields="'name':1,'id':1")
	public List<ProductInfo> findByShopId(String shopId);
	
	public List<ProductInfo> findByName(String name);
	public List<ProductInfo> findByDescription(String desctription);
	public List<ProductInfo> findByDescriptionLike(String desctription);

	
}
