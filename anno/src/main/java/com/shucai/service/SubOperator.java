package com.shucai.service;

import com.shucai.registrar.Operator;

@Operator("#a - #b")
public interface SubOperator {

    Object sub(int a, int b);
}
