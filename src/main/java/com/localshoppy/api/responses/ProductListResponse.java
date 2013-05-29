package com.localshoppy.api.responses;

import java.util.List;

import org.springframework.stereotype.Component;

import com.localshoppy.api.data.model.ProductInfo;

@Component
public class ProductListResponse extends BaseApiResponse{

	private int count;
	private List<ProductInfo> productListDetails;

	public List<ProductInfo> getProductListDetails() {
		return productListDetails;
	}

	public void setProductListDetails(List<ProductInfo> productListDetails) {
		this.productListDetails = productListDetails;
		setCount(productListDetails.size());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
