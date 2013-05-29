package com.localshoppy.api.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.localshoppy.api.data.model.ProductInfo;
import com.localshoppy.api.resource.MongoDao;
import com.localshoppy.api.responses.BaseApiResponse;
import com.localshoppy.api.responses.ProductInfoResponse;
import com.localshoppy.api.responses.ProductListResponse;
import com.localshoppy.api.responses.StaticResponse;
import com.localshoppy.api.service.ProductRepository;

@Controller
@RequestMapping("/products")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private MongoDao mongoDao;

	@Autowired
	private ProductRepository repository;

	@RequestMapping(value="/insert" ,method=RequestMethod.GET)
	public @ResponseBody BaseApiResponse addProduct(ProductInfo product, String shopId, BindingResult result){
		if (result.hasErrors()) {
			return StaticResponse.error;
		}

		logger.info(product.toString());
		try{
			mongoDao.addDoc(product);
		} catch (DuplicateKeyException e) {
			logger.error("error : " + e);
		} catch (DataAccessResourceFailureException e) {
			logger.error("error : " + e);
		}catch(Exception e){
			logger.error("error : " + e);
		}

		return StaticResponse.success;
	}

	@RequestMapping(value="/id/{productId}" ,method=RequestMethod.GET)
	public @ResponseBody ProductInfoResponse getProductDetails(@PathVariable("productId") String id){
		ProductInfoResponse productInfoResponse = new ProductInfoResponse();

		productInfoResponse.setProductDetails(repository.findById(id));
		
		if(productInfoResponse.getProductDetails() == null){
			productInfoResponse.code = 404;
			productInfoResponse.message = "Product with id " + id + " could not be found";
		}
		
		logger.info(productInfoResponse.getProductDetails().toString());
		return productInfoResponse;
	}

	@RequestMapping(value="/shop/{shopId}", method=RequestMethod.GET)
	public @ResponseBody ProductListResponse getProductsByShop(@PathVariable("shopId")String shopId){
		ProductListResponse p = new ProductListResponse();
		
		p.setProductListDetails(repository.findByShopId(shopId));
		if(p.getProductListDetails() == null || p.getProductListDetails().size() == 0){
			p.code = 404;
			p.message = "No product with shop id " + shopId + " found";
		}
		
		logger.info(p.toString());
		
		return p;
	}
}
