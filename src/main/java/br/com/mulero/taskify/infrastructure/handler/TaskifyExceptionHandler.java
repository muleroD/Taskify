package br.com.mulero.taskify.infrastructure.handler;

import br.com.mulero.taskify.infrastructure.exception.NotFoundException;
import br.com.mulero.taskify.infrastructure.exception.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class TaskifyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e, WebRequest request) {
        return buildApiError(e, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException e, WebRequest request) {
        return buildApiError(e, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException e, WebRequest request) {
        return buildApiError(e, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    public ResponseEntity<Object> handleInvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e, WebRequest request) {
        return buildApiError(e, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception e, WebRequest request) {
        log.error("Erro não mapeado", e);
        return buildApiError(e, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> buildApiError(Exception e, WebRequest request, HttpStatus httpStatus) {
        return buildApiError(e, request, httpStatus, new HttpHeaders());
    }

    private ResponseEntity<Object> buildApiError(Exception ex, WebRequest request, HttpStatus status, HttpHeaders headers) {
        ProblemDetail body = this.createProblemDetail(ex, status, ex.getMessage(), null, null, request);
        return this.handleExceptionInternal(ex, body, headers, status, request);
    }

}
