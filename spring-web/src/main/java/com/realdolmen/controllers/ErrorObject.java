package com.realdolmen.controllers;

public class ErrorObject {

	private Status status;
	private String message;
	
	public ErrorObject(Status status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
