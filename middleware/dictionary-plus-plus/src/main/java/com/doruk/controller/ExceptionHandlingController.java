package com.doruk.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.doruk.exception.InternalServerErrorException;
import com.doruk.exception.NoResultException;
import com.doruk.response.ExceptionResponse;
import com.doruk.response.Response;

@ControllerAdvice
public class ExceptionHandlingController {
	private static Logger LOG = LoggerFactory.getLogger(ExceptionHandlingController.class);

	@ExceptionHandler(NoResultException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody Response handleResultNotFoundException(HttpServletRequest request, Exception e) {
		LOG.info(request.getRequestURL().toString(), e);
		return new ExceptionResponse(e);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody Response handleIllegalArgumentException(HttpServletRequest request, Exception e) {
		LOG.info(request.getRequestURL().toString(), e);
		return new ExceptionResponse(e);
	}

	@ExceptionHandler(InternalServerErrorException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody Response handleInternalServerErrorException(HttpServletRequest request, Exception e) {
		LOG.error(request.getRequestURL().toString(), e.getMessage(), e);
		return new ExceptionResponse(e);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody Response handleException(HttpServletRequest request, Exception e) {
		LOG.error(request.getRequestURL().toString(), e.getMessage(), e);
		return new ExceptionResponse(e);
	}
}
