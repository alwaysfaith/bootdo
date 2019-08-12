package com.bootdo.common.utils;

import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * 报文结果对象
 *
 * @param <T>
 * @author lijie.zh
 */
public final class Return<T> extends AbstractResultMsg<T> {

    private static final long serialVersionUID = -4007925434378307661L;

    private Return() {
        setHttpStatus(HttpStatus.OK.value());
        setErrorCode(ErrorCode.SUCCESS.getCode());
        setMessage(ErrorCode.SUCCESS.getPrompt());
    }


    private Return(HttpStatus httpStatus, String message, String errorCode) {
        setHttpStatus(httpStatus.value());
        setMessage(message);
        setErrorCode(errorCode);
    }

    private Return(T data) {
        setHttpStatus(HttpStatus.OK.value());
        setErrorCode(ErrorCode.SUCCESS.getCode());
        setMessage(ErrorCode.SUCCESS.getPrompt());
        this.setData(data);
    }

    public Return(HttpStatus httpStatus, String message, String errorCode, T data) {
        setHttpStatus(httpStatus.value());
        setMessage(message);
        setErrorCode(errorCode);
        setData(data);
    }

    public static Return success() {
        return new Return<>();
    }

    public static Return success(String message, String errorCode) {
        return new Return<>(HttpStatus.OK, message, errorCode);
    }

    public static <T> Return<T> success(T data) {
        return new Return<>(data);
    }

    public static <T> Return<List<T>> success(List<T> data) {
        return new Return<>(data);
    }

    public static Return error(HttpStatus httpStatus , String errorCode, String message) {
        return new Return<>(httpStatus, message, errorCode);
    }

}
