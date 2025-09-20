package com.yamato.authjava.http;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ErrorResponse {
    public ErrorBody error;

    public ErrorResponse(String code, String message) {
        this.error = new ErrorBody(code, message);
    }

    public static ErrorResponse of(String code, String message) {
        return new ErrorResponse(code, message);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ErrorBody {
        public String code;
        public String message;
        public ErrorBody(String c, String m) {
            this.code = c;
            this.message = m;
        }
    }
}
