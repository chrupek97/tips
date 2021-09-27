package pl.matkac.tips.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ElementNotFoundException extends Exception{
    public ElementNotFoundException(String message) {
        super(message);
    }
}
