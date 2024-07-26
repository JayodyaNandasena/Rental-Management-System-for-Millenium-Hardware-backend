package edu.icet.crm.exception;

import edu.icet.crm.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException ex){
        ErrorResponse response = ErrorResponse.builder()
                .status("Failed")
                .errorMessage(ex.getMessage())
                .build();

        return ResponseEntity.ok().body(response);
    }

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<ErrorResponse> handleInvalidParameterException(InvalidParameterException ex){
        ErrorResponse response = ErrorResponse.builder()
                .status("Failed")
                .errorMessage(ex.getMessage())
                .build();

        return ResponseEntity.ok().body(response);
    }

}
