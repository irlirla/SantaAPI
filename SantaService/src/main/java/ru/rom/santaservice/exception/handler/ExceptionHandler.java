package ru.rom.santaservice.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.rom.santaservice.exception.ApplicationException;
import ru.rom.santaservice.exception.BadBehavior;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(
            value = {ApplicationException.class, BadBehavior.class})
    public ResponseEntity<String> handleException(RuntimeException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
