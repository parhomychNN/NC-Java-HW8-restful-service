package ru.parhomych.restfulwebservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcepion extends Exception {
    public ResourceNotFoundExcepion(String message) {
        super(message);
    }
}
