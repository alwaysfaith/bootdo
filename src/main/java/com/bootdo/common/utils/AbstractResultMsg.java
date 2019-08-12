package com.bootdo.common.utils;

import lombok.Data;

import java.io.Serializable;


/**
 * @param <T>
 * @author lijie.zhong
 */
@Data
public abstract class AbstractResultMsg<T> implements Serializable {

    private static final long serialVersionUID = -460940260853796524L;
    protected String errorCode;

    protected String message;

    protected int httpStatus;

    protected T data;




}