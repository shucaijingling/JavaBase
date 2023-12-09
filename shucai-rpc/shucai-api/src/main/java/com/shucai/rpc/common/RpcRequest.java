package com.shucai.rpc.common;

import lombok.Data;

/**
 * @author 蔬菜精灵
 */
@Data
public class RpcRequest {
    
    private String requestId;
    
    private String className;
    
    private String methodName;
    
    private Class<?>[] parameterTypes;
    
    private Object[] parameters;
}
