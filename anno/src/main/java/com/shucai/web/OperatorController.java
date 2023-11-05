package com.shucai.web;

import com.shucai.service.AddOperator;
import com.shucai.service.SubOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperatorController {
    @Autowired
    private AddOperator addOperator;

    @Autowired
    private SubOperator subOperator;

    @GetMapping("/add")
    public Object add() {
        return addOperator.add(1, 2);
    }

    @GetMapping("/sub")
    public Object sub() {
        return subOperator.sub(5, 1);
    }
}
