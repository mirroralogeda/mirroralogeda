package com.mirror.alogeda.commons.exceptions;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String domainMessage;

	public DomainException(String message) {
		super(message);
		this.domainMessage = message;
	}

	public DomainException(String domainMessage, String message) {
		super(message);
		this.domainMessage = domainMessage;
	}

	public DomainException(String message, Throwable inner) {
		super(message, inner);
		this.domainMessage = message;
	}

	public DomainException(String domainMessage, String message, Throwable inner) {
		super(message, inner);
		this.domainMessage = domainMessage;
	}

	public String getDomainMessage() {
		return domainMessage;
	}

}
