package com.mycompany.nubulamusicwebaplication.dto;

public class ResponseMessageDTO {
    private boolean success;
    private String message;

    public ResponseMessageDTO() {}

    public ResponseMessageDTO(String message, boolean success) {
        this.message = message;
        this.success = success;
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
