package com.shucai.mapper;

import com.shucai.muti.pojo.Order;

import java.util.List;

public interface IOrderMapper {

    public List<Order> findOrderAndUser();

}
