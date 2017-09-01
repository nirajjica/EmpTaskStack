package com.eschool.dto;

import java.io.Serializable;

public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean status;
	private String message;
	private Object data;

	public Message(){}
	public Message(String message){
		this.message=message;
	}
	public Message(boolean status,String message){
		this.status=status;
		this.message=message;
	}
	
	public Message(boolean status,String message,Object data){
		this.status=status;
		this.message=message;
		this.data=data;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Message [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
}
