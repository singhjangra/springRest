package djh.learn.springRest.controller;

public class CustomerExceptionHandler extends RuntimeException{

	public CustomerExceptionHandler(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerExceptionHandler(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomerExceptionHandler(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
