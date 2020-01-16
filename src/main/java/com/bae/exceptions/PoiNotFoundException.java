package com.bae.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This poi does not exist")
public class PoiNotFoundException extends EntityNotFoundException {



        private static final long serialVersionUID = -2591687720244290021L;
}
