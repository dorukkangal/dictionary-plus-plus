package com.doruk.response;

import java.util.ArrayList;
import java.util.List;

public abstract class Response {

	private List<String> results;

	public Response() {
		this(new ArrayList<String>());
	}
	
	public Response(String result) {
		this(new ArrayList<String>());
		add(result);
	}

	public Response(List<String> results) {
		this.results = results;
	}

	public List<String> getResults() {
		return results;
	}
	
	public void add(String result) {
		results.add(result);
	}
}
