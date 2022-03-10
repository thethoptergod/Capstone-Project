package com.WhiskeyandWaveforms.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class WAWException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
    public WAWException(String message) {
    	super(message);
    }
}
