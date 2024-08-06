package com.example.BANK_FAHRI.controller;

import com.example.BANK_FAHRI.entity.User;
import com.example.BANK_FAHRI.model.ApiResponse;
import com.example.BANK_FAHRI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        List<User> data;
        String error = null;
        int status = 200;
        String message = null;
        HttpStatus httpStatus = HttpStatus.OK; // Default status

        try {
            data = userService.getAllUser();
        } catch (RuntimeException e) {
            data = null;
            status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            error = "Internal Server Error";
            message = e.getMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        ApiResponse<List<User>> response = new ApiResponse<>(status, error, data, message);
        return new ResponseEntity<>(response, httpStatus);

    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ApiResponse<Optional<User>>> getUser(@PathVariable UUID uuid) {
        Optional<User> data = Optional.empty();
        String error = null;
        int status = 200;
        String message = null;
        HttpStatus httpStatus = HttpStatus.OK;

        try {
            data = userService.getUserById(uuid);
        } catch (NoSuchElementException e) {
            status = HttpStatus.NOT_FOUND.value();
            error = "Not Found";
            message = e.getMessage();
            httpStatus = HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR.value();;
            error = "Internal Server Error";
            message = e.getMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        ApiResponse<Optional<User>> response = new ApiResponse<>(status, error, data, message);
        return new ResponseEntity<>(response, httpStatus);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createUser(@RequestBody User user) {
        String data = null;
        String error = null;
        int status = 200;
        String message = "success";
        HttpStatus httpStatus = HttpStatus.OK;

        try {
            UUID uuid = UUID.randomUUID();

            user.setUuid(uuid);
            userService.saveUser(user);

        } catch (RuntimeException e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR.value();;
            error = "Internal Server Error";
            message = e.getMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        ApiResponse<String> response = new ApiResponse<>(status, error, data, message);
        return new ResponseEntity<>(response, httpStatus);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable UUID uuid) {
        String error = null;
        int status = 200;
        String message = "success";
        HttpStatus httpStatus = HttpStatus.OK;

        try {
            userService.deleteUser(uuid);
        } catch (NoSuchElementException e) {
            status = HttpStatus.NOT_FOUND.value();;
            error = "Not Found";
            message = e.getMessage();
            httpStatus = HttpStatus.NOT_FOUND;
        } catch (RuntimeException e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR.value();;
            error = "Internal Server Error";
            message = e.getMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        ApiResponse<String> response = new ApiResponse<>(status, error, null, message);
        return new ResponseEntity<>(response, httpStatus);
    }

    @PatchMapping("/{uuid}")
    public ResponseEntity<ApiResponse<String>> updateUser(@PathVariable UUID uuid, @RequestBody User user) {
        String error = null;
        int status = 200;
        String message = null;
        HttpStatus httpStatus = HttpStatus.OK;

        try {
            userService.updateUser(uuid, user);
        } catch (NoSuchElementException e) {
            status = HttpStatus.NOT_FOUND.value();;
            error = "Not Found";
            message = e.getMessage();
            httpStatus = HttpStatus.NOT_FOUND;
        } catch (RuntimeException e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR.value();;
            error = "Internal Server Error";
            message = e.getMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        ApiResponse<String> response = new ApiResponse<>(status, error, null, message);
        return new ResponseEntity<>(response, httpStatus);
    }
}