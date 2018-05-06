package com.lvbby.garfield.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import java.util.List;

/**
 * Created by lipeng on 2018/05/06.
 */
@Mapper
public interface OrderConvert {

    OrderConvert INSTANCE = Mappers.getMapper(OrderConvert.class);

    static OrderConvertConvertor instance() {
        return INSTANCE;
    }

    @Mappings({})
    Order toOrder(OrderDTO orderDTO);

    @Mappings({})
    OrderDTO toOrderDTO(Order order);

    List<OrderDTO> toOrderDTOs(List<Order> orders);

    List<Order> toOrders(List<OrderDTO> orderDTOs);
}
