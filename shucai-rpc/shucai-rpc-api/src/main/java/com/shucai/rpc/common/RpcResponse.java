package com.shucai.rpc.common;

import lombok.Data;

/**
 * 封装响应的对象
 */
@Data
public class RpcResponse {

    /**
     * 响应ID
     */
    private String responseId;

    /**
     * 错误信息
     */
    private String error;

    /**
     * 返回结果
     */
    private Object result;
}
