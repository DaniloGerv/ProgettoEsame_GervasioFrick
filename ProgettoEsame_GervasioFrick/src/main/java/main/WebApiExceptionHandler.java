package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * Classe utilizzata per gestire tutte le eccezioni generate dall'esecuzione di una URI errato (filtro errato,
 * valore del map errato ecc..) da parte dell'utente.
 * @author danilogervasio
 *
 */
@ControllerAdvice
public class WebApiExceptionHandler extends ResponseEntityExceptionHandler{		
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex,WebRequest request){
		return new ResponseEntity<>("ERROR MESSAGE: wrong data insert! Check the correction of the URI",HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
