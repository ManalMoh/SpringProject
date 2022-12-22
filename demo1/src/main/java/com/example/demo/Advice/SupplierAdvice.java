package com.example.demo.Advice;

import com.example.demo.Dto.ApiResponse;
import com.example.demo.Exption.ApiExption;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
@RestControllerAdvice
public class SupplierAdvice{
    @ExceptionHandler(value = ApiExption.class)
    public ResponseEntity ApiExption(ApiExption e){
    String message=e.getMessage();
    return ResponseEntity.status(400).body(message);
}


        @ExceptionHandler(value = ConstraintViolationException.class)
        public ResponseEntity ConstraintViolationException(ConstraintViolationException e){
            String message=e.getMessage();
            return ResponseEntity.status(400).body(message);
        }


        @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
        public ResponseEntity<ApiResponse> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
            String msg=e.getMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }


        @ExceptionHandler(value = DataIntegrityViolationException.class)
        public ResponseEntity<ApiResponse> DataIntegrityViolationException(DataIntegrityViolationException e){
            String msg=e.getMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }


        @ExceptionHandler(value = EntityNotFoundException.class)
        public ResponseEntity<ApiResponse> EntityNotFoundException(EntityNotFoundException e) {
            String msg = e.getMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }


        @ExceptionHandler(value = MethodArgumentNotValidException.class)
        public ResponseEntity<ApiResponse> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
            String msg = e.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }


        @ExceptionHandler(value = HttpMessageNotReadableException.class)
        public ResponseEntity<ApiResponse> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
            String msg = e.getMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }
}
