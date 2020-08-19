package com.wellsfargo.coronakit.exception;

public class CoronaException extends Exception{

	private static final long serialVersionUID = 1L;

	public CoronaException(String errMsg)
	{
		super(errMsg);
	}
}
