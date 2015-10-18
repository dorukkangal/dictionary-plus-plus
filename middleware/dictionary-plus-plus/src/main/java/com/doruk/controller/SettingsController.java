package com.doruk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.doruk.request.SearchType;

@RestController
@RequestMapping(value = "/")
public class SettingsController {
	private static Logger LOG = LoggerFactory.getLogger(SearchController.class);

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody ModelAndView checkHealth() throws Exception {
		LOG.debug("Health check");
		return new ModelAndView("index");
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/settings", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" })
	public @ResponseBody SearchType[] search() throws Exception {
		LOG.debug("Settings request");
		return SearchType.values();
	}
}
