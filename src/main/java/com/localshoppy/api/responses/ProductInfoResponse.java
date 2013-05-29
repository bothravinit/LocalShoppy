package com.localshoppy.api.responses;

import org.springframework.stereotype.Component;

import com.localshoppy.api.data.model.ProductInfo;

@Component
public class ProductInfoResponse extends BaseApiResponse{

	private ProductInfo productDetails;

	public ProductInfo getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductInfo productDetails) {
		this.productDetails = productDetails;
	}
	
}
