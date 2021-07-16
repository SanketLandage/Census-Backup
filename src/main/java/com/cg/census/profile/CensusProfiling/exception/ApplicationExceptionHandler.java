package com.cg.census.profile.CensusProfiling.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.census.profile.CensusProfiling.model.APIError;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	//when a RecordNotFoundException is thrown, then this method is used to catch
	//This can be called by any methods, from users as well as admins.
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<APIError> handleRecordNotFoundException(Exception e) {
		HttpStatus status = HttpStatus.NOT_FOUND;

		APIError apiError = new APIError();
		apiError.setMsg(e.getMessage());
		apiError.setHttpStatus(status);
		ResponseEntity<APIError> resEntity = new ResponseEntity<>(apiError, status);
		return resEntity;
	}
	//when a RecordNotFoundException is thrown, then this method is used to catch
	@ExceptionHandler(DuplicateRecordException.class)
	public ResponseEntity<APIError> handleDuplicateRecordException(Exception e) {
		HttpStatus status = HttpStatus.CONFLICT;

		APIError apiError = new APIError();
		apiError.setMsg(e.getMessage());
		apiError.setHttpStatus(status);
		ResponseEntity<APIError> resEntity = new ResponseEntity<>(apiError, status);
		return resEntity;
	}

	//when any other exception is thrown, then this method is used to catch the exception
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<APIError> otherExceptions(Exception e) {
		HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;

		APIError apiError = new APIError();
		apiError.setMsg(e.getMessage());
		apiError.setHttpStatus(status);
		ResponseEntity<APIError> resEntity = new ResponseEntity<>(apiError, status);
		return resEntity;
	}
	
	//when any form of validation error occurs then this method is used to catch
	@ResponseStatus(HttpStatus.BAD_REQUEST) // always send BadRequest to client
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField(); // reading the error field
			String errorMessage = error.getDefaultMessage();// reading the error msg
			errors.put(fieldName, errorMessage); // put in the map
		});
		return errors;
	}
}