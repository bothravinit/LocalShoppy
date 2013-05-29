package com.localshoppy.api.data.model;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;

//@XmlRootElement
@TypeAlias(value = "products")
//@Document(collection = "products")
public class ProductInfo {

	@Id
	private String id;
	
	@NotEmpty
	private String name;
	private String description;
	private String imageUrl;
	private int quantity;
	
	private Map<String, ArrayList<String>> variants;
	
	@Indexed
	@NotEmpty
	private String shopId;
	
//	@Reference private ShopInfo shopInfo;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		try{
		this.quantity = Integer.parseInt(quantity);
		}catch(Exception e){
			this.quantity=0;
		}
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public Map<String, ArrayList<String>> getVariants() {
		return variants;
	}

	public void setVariants(Map<String, ArrayList<String>> variants) {
		this.variants = variants;
	}
}
