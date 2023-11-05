package com.shucai.service;

import com.shucai.registrar.Operator;

@Operator("#a + #b")
public interface AddOperator {

    Object add(int a, int b);
}
