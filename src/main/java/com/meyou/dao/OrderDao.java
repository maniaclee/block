package com.meyou.dao;

import com.meyou.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lipeng on 2018/05/06.
 */
public interface OrderDao {

    int add(OrderEntity orderEntity);

    OrderEntity selectByOrderId(@Param(value = "orderId") String orderId);
}
