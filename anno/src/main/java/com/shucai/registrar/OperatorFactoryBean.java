package com.shucai.registrar;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class OperatorFactoryBean implements FactoryBean<Object>, InitializingBean {
    private Class<?> type;

    private String expression;

    private Expression spelExpression;

    @Override
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(type.getClassLoader(),
                new Class[]{type},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] agrs) throws Throwable {
                        EvaluationContext context = new StandardEvaluationContext();
                        char var = 'a';
                        for (Object agr : agrs) {
                            context.setVariable(String.valueOf(var++), agr);
                        }
                        return spelExpression.getValue(context);
                    }
                });
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ExpressionParser parser = new SpelExpressionParser();
         this.spelExpression = parser.parseExpression(this.expression);
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
