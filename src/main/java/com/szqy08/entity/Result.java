package com.szqy08.entity;

import com.szqy08.entity.LayuiTable;
import lombok.Data;

/**
 * fileName:Result
 * description:
 * @author:cxj
 * createTime:2020/7/18 0018 上午 10:40
 * version:1.0.0
 */
@Data
public class Result<T> {
    /** 返回的状态码 */
    private int code;
    /** 提示信息 */
    private String msg;
    /** 返回的数据 */
    private T data;
}
