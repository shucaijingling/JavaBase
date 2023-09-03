package com.shucai.template;

import com.shucai.template.request.Request;

public class MainTest {

    public static void main(String[] args) {

        TemplateOne.process(new Request(),
                new BizHandle() {
                    @Override
                    public Object doBiz(Object o) {

                        return null;
                    }
                });
    }
}
