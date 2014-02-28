package com.realdolmen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
 * Every Controller should inherit this. It provides common methods for all Controllers
 * @author Marco Brasci
 *
 */
public abstract class AbstractController {

	/**
	 * Get translation messages from this object
	 */
	@Autowired 
	private MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

}
