package com.taim.jetdash.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @Author Niraj Kumar
 * @CreatedOn 30-Aug-2017
 */

@JsonInclude(Include.NON_NULL)
public class ResponseDTO {

	private String response_code;
	private String response_message;
	private Object data = null;
	
	public ResponseDTO(){}
	
	public ResponseDTO(String response_code, String response_message) {
		this.response_code = response_code;
		this.response_message = response_message;
	}
	
	public String getResponse_code() {
		return response_code;
	}

	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}

	public String getResponse_message() {
		return response_message;
	}
	
	public void setResponse_message(String response_message) {
		this.response_message = response_message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}