package com.localshoppy.api.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.localshoppy.api.data.model.ShopInfo;
import com.localshoppy.api.resource.MongoDao;
import com.localshoppy.api.responses.BaseApiResponse;
import com.localshoppy.api.responses.StaticResponse;
import com.localshoppy.api.service.ShopRepository;

@Controller
@RequestMapping("/shops")
public class ShopController {
	private static final Logger logger = LoggerFactory
			.getLogger(ShopController.class);

	@Autowired
	private MongoDao mongoDao;

	@Autowired
	private ShopRepository repository;

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public @ResponseBody
	BaseApiResponse addProduct(@Valid ShopInfo shop, BindingResult result) {
		if (result.hasErrors()) {
			logger.error(result.toString());
			return StaticResponse.error;
		}

		logger.debug(shop.toString());
		try{
			mongoDao.addDoc(shop);
		} catch (DuplicateKeyException e) {
			logger.error("error : " + e);
		} catch (DataAccessResourceFailureException e) {
			logger.error("error : " + e);
		}catch(Exception e){
			logger.error("error : " + e);
		}
		
		return StaticResponse.success;
	}

}
