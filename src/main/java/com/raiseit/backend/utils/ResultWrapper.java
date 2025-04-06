package com.raiseit.backend.utils;

public class ResultWrapper<T>  {
    private boolean success;
    private String message;
    private T data;

    public ResultWrapper() {}

    public ResultWrapper(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultWrapper<T> success(String message, T data) {
        return new ResultWrapper<>(true, message, data);
    }

    public static <T> ResultWrapper<T> failure(String message) {
        return new ResultWrapper<>(false, message, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
