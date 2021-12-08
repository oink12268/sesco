package com.eggplant.sesco.presentation.http.response;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private Integer value;
    private String message;
    private String details;

    public ExceptionResponse(Integer value, String message, String details) {
        super();
        this.value = value;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
