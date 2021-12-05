package djh.learn.springRest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomerExceptionController {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> error(CustomerExceptionHandler ex)
	{
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<CustomerErrorResponse> showCustomMessage(Exception e){
 
 
		CustomerErrorResponse response = new CustomerErrorResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(e.getMessage());
		response.setTimeStamp(System.currentTimeMillis());
 
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
