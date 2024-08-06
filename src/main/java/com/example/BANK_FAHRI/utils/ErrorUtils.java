package com.example.BANK_FAHRI.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.BANK_FAHRI.model.ApiResponse;

public class ErrorUtils {

    public static <T> ResponseEntity<ApiResponse<T>> buildErrorResponse(HttpStatus status, String errorMessage) {
        ApiResponse<T> apiResponse = new ApiResponse<>(status.value(), errorMessage, null, status.getReasonPhrase());
        return new ResponseEntity<>(apiResponse, status);
    }
}