package com.doruk.request;

public enum SearchType {
	Tureng("tureng"), Zargan("zargan");

	private String dictionary;

	private SearchType(String dictionary) {
		this.dictionary = dictionary;
	}

	@Override
	public String toString() {
		return dictionary;
	}

	public static SearchType getSearchType(String name) {
		if (name == null)
			throw new NullPointerException("Name is null");
		for (SearchType type : values()) {
			if (type.toString().equals(name.toUpperCase()))
				return type;
		}
		throw new IllegalArgumentException("No enum constant " + SearchType.class.getSimpleName() + "." + name);
	}
}