package com.ifli.mbcp.dao.exceptions;

/**
 * @author sureshkumar
 * 
 */
public class DAOException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DAOException() {
	}

	/**
	 * @param message
	 */
	public DAOException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DAOException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

}
