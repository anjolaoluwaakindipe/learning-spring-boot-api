package com.learningspringboot.learningspringboot.ui.model.response;

import java.util.Date;

public class ErrorMessage {

    private Date timeStamp;
    private String message;
    private boolean success;

    public ErrorMessage(Date timeStamp, String message, boolean success) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.success = success;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
