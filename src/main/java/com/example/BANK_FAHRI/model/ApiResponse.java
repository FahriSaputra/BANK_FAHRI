package com.example.BANK_FAHRI.model;

import lombok.Data;

@Data
public class ApiResponse<T>{
    private T data;
    private String error;
    private int status;
    private String message;

    public ApiResponse(int status, String error,T data, String message) {
        this.status = status;
        this.data = data;
        this.error = error;
        this.message = message;
    }
}
