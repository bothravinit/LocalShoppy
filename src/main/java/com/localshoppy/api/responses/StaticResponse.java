package com.localshoppy.api.responses;

import org.springframework.http.HttpStatus;

public class StaticResponse {

	public static final BaseApiResponse success = new BaseApiResponse(HttpStatus.OK.value(),"Request accepted");
	public static final BaseApiResponse error = new BaseApiResponse(HttpStatus.OK.value(),"Request contains error");

}
