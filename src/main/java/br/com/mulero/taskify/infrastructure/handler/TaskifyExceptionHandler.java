package br.com.mulero.taskify.infrastructure.handler;

import br.com.mulero.taskify.infrastructure.exception.NotFoundException;
import br.com.mulero.taskify.infrastructure.exception.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class TaskifyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.badRequest().body(buildApiError(e, HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistException(UserAlreadyExistException e) {
        return ResponseEntity.badRequest().body(buildApiError(e, HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return ResponseEntity.badRequest().body(buildApiError(e, HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    public ResponseEntity<ErrorResponse> handleInvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e) {
        return ResponseEntity.badRequest().body(buildApiError(e, HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.badRequest().body(buildApiError(e, HttpStatus.INTERNAL_SERVER_ERROR));
    }

    private ErrorResponse buildApiError(Exception ex, HttpStatus status) {
        return ErrorResponse.create(ex, status, ex.getMessage());
    }
}
