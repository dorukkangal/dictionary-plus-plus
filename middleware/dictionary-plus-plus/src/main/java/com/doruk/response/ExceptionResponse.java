package com.doruk.response;

public class ExceptionResponse extends Response {

	public ExceptionResponse(Exception e) {
		super(e.getMessage());
	}
}
