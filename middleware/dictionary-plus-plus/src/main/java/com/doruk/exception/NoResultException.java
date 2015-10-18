package com.doruk.exception;

public class NoResultException extends Exception {
	private static final long serialVersionUID = 1L;

	public static final String ERROR_MESSAGE = "Hiç sonuç bulunamadı :(";

	public NoResultException() {
		super(ERROR_MESSAGE);
	}
}
