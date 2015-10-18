package com.doruk.service;

import java.util.List;

import com.doruk.exception.NoResultException;

public interface DictionaryService {

	public List<String> search(String word) throws NoResultException;
}
