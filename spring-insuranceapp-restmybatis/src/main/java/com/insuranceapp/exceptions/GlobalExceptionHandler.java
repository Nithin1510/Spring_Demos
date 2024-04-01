package com.insuranceapp.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.insuranceapp.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	// 2
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		LocalDateTime timeStamp = LocalDateTime.now();
		HttpStatus statusMessage = HttpStatus.valueOf(status.value());
		ApiErrors errors = new ApiErrors(timeStamp, status.value(), ex.getMessage(), statusMessage);
		headers.add("error", "Media Type Not Supported");
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	// 1
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		LocalDateTime timeStamp = LocalDateTime.now();
		HttpStatus statusMessage = HttpStatus.valueOf(status.value());
		ApiErrors errors = new ApiErrors(timeStamp, status.value(), ex.getMessage(), statusMessage);
		headers.add("error", "Method not allowed");
		return ResponseEntity.status(status).headers(headers).body(errors);
	}
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		LocalDateTime timeStamp = LocalDateTime.now();
		HttpStatus statusMessage = HttpStatus.valueOf(status.value());
		ApiErrors errors = new ApiErrors(timeStamp, status.value(), ex.getMessage(), statusMessage);
		headers.add("error", "Missing Servlet Request Parameter");
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		LocalDateTime timeStamp = LocalDateTime.now();
		HttpStatus statusMessage = HttpStatus.valueOf(status.value());
		ApiErrors errors = new ApiErrors(timeStamp, status.value(), ex.getMessage(), statusMessage);
		headers.add("error", "Missing Path Variable");
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		LocalDateTime timeStamp = LocalDateTime.now();
		HttpStatus statusMessage = HttpStatus.valueOf(status.value());
		ApiErrors errors = new ApiErrors(timeStamp, status.value(), ex.getMessage(), statusMessage);
		headers.add("error", "Type Mismatch");
		return ResponseEntity.status(status).headers(headers).body(errors);
	}
	
	
	// 6
	@ExceptionHandler(InsuranceNotFoundException.class)
	public ResponseEntity<Object> handleInsuranceNotFoundException(InsuranceNotFoundException ex){
		LocalDateTime timeStamp = LocalDateTime.now();
		HttpStatus statusMessage = HttpStatus.BAD_REQUEST;
		ApiErrors errors = new ApiErrors(timeStamp, statusMessage.value(), ex.getMessage(), statusMessage);
		HttpHeaders headers = new HttpHeaders();
		headers.add("error", "Insurance Not Found Exception");
		return ResponseEntity.status(statusMessage).headers(headers).body(errors);
	}

}


