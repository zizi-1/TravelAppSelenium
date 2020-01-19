package com.bae.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This details do not exist")
public class DetailsNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = -2591687720244290021L;
}
