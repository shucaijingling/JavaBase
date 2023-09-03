package com.shucai.template;

import com.shucai.template.request.NewRequest;
import com.shucai.template.request.Request;
import com.shucai.template.response.NewResponse;

public class TemplateOne {

    public static NewResponse process(Request request, BizHandle bizHandle) {
        try {
            NewRequest newRequest = bulidReq(request);
            bizHandle.prepare();
            Object resp = bizHandle.doBiz(newRequest);
            NewResponse newResponse = changeResp(resp);
            return newResponse;
        }catch (Exception e) {
            //setErrorCode
        }


        return new NewResponse();
    }

    private static NewResponse changeResp(Object resp) {
        NewResponse newResponse = new NewResponse();
        return newResponse;
    }

    private static NewRequest bulidReq(Request request) {
        NewRequest newRequest = new NewRequest();
        return newRequest;
    }
}
