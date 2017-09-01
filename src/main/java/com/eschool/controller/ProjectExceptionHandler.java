package com.eschool.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(basePackages = "com.eschool")
public class ProjectExceptionHandler {

    private class ExceptionDTO {
        public String field;

        public String message;

        ExceptionDTO(final String field, final String message) {
            this.field = field;
            this.message = message;
        }
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity handleBadRequest(final ConstraintViolationException e, final WebRequest request) {
        final List<ExceptionDTO> exceptionEntities = e.getConstraintViolations().stream()
                .map(violation -> new ExceptionDTO(violation.getPropertyPath().toString(), violation.getMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(exceptionEntities);
    }
}
