package minhquan.com.exception.impl;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {
    private final int code;
    private final String description;

    public BadRequestException(int code, String description) {
        this.code = code;
        this.description = description;
    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public String getDescription() {
//        return description;
//    }
}
