package com.shucai.rpc.common;

import lombok.Data;

/**
 * @author 蔬菜精灵
 */

@Data
public class RpcResponse {
    
    private String requestId;
    
    private String error;
    
    private Object result;
}
