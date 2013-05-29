package com.localshoppy.api.responses;

//@XmlRootElement
public class BaseApiResponse {

	public int code = 200;
	public String message = "success";

	public BaseApiResponse() {
	}

	public BaseApiResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}

}
