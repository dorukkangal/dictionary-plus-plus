package com.doruk.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.doruk.request.SearchType;
import com.doruk.service.DictionaryService;

@RestController
@RequestMapping(value = "/search")
public class SearchController {
	private static Logger LOG = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	private DictionaryService tureng;

	@Autowired
	private DictionaryService zargan;

	@ResponseStatus(HttpStatus.FOUND)
	@RequestMapping(value = "/{type}/{word}", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8" })
	public @ResponseBody List<String> search(@PathVariable String type, @PathVariable String word) throws Exception {

		SearchType searchType = SearchType.getSearchType(type);
		LOG.debug("Search request--> Word: {} Type: {}", word, type);
		if (searchType == SearchType.Tureng) {
			return tureng.search(word);
		} else {
			return zargan.search(word);
		}
	}
}
