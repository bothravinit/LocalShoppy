package com.localshoppy.api;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.localshoppy.api.data.model.ProductInfo;
import com.localshoppy.api.resource.MongoDao;
import com.localshoppy.api.service.ProductRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private MongoDao mongoDao;

	@Autowired
	private ProductRepository repository;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,
			@RequestParam(defaultValue = "hello") String val,
			@RequestParam(defaultValue = "20") int size) {
		
		
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

//		ProductInfo q = mongoDao.mt.findOne(
//				new Query(Criteria.where("id").is("51800fd530046c4b6c7405a8")),
//				ProductInfo.class);
//		System.out.println(q.getName());
//
//		System.out.println(repository.count());
//		System.out.println(repository.findByDescription("8").size());
//		System.out.println(repository.findByDescriptionLike("8").size());
//		System.out.println("val = " + val);
//		System.out.println("size = " + size);
//
//		
//		
//		
		return "home";
	}

}
