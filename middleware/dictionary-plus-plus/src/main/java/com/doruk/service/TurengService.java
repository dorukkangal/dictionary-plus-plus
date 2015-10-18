package com.doruk.service;

import java.util.List;

import com.doruk.exception.NoResultException;

public class TurengService implements DictionaryService {

	public List<String> search(String word) throws NoResultException {
		throw new NoResultException();
	}
}
