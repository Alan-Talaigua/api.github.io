package co.edu.udemedellin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice(basePackages = "")
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Throwable> handleResponseStatusExceptions(Exception ex) {
        log.error(ex.toString());
        return new ResponseEntity<>(ex.getCause(),  HttpStatus.INTERNAL_SERVER_ERROR);
    }
}