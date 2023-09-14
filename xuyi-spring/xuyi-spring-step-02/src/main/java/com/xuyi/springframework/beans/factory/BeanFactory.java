package com.xuyi.springframework.beans.factory;

import com.xuyi.springframework.beans.BeanException;

/**
 * bean工厂
 */
public interface BeanFactory {

    Object getBean(String name) throws BeanException;
}
