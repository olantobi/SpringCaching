package com.myapp.exception;

public enum ResultStatusConstants {
	SUCCESS(0),
	// exception caught
	INTERNAL_ERROR(9000),
	PARTIAL_DB_UPDATE(8000);
	private int statusCode;
	private ResultStatusConstants(final int resultStatusCode) {
		this.statusCode = resultStatusCode;
	}

	public int getCode() {
		return statusCode;
	}

}
