package id.co.lua.polua.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "bad_request")
public class BadRequestException extends RuntimeException {
    
}
