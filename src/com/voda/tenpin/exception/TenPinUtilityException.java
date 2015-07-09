package com.voda.tenpin.exception;

public class TenPinUtilityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message = null;
	public TenPinUtilityException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TenPinUtilityException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public TenPinUtilityException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public TenPinUtilityException(String message) {
		super(message);
		this.message = message;
	}

	public TenPinUtilityException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public String toString() {
        return message;
    }

  	@Override
  	public String getMessage() {
      return message;
  	}
}
