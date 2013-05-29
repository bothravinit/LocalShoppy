package com.localshoppy.api.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.Repository;

import com.localshoppy.api.data.model.ShopInfo;

public interface ShopRepository extends Repository<ShopInfo, Long> {

	public long count();

	public ShopInfo findById(ObjectId id);

	public List<ShopInfo> findByName(String name);
	public List<ShopInfo> findByDescription(String desctription);
	public List<ShopInfo> findByDescriptionLike(String desctription);

	
}
