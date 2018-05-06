package com.lvbby.garfield.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import java.util.List;

/**
 * Created by lipeng on 2018/05/06.
 */
@Mapper
public interface MeyouOrderConvert {

    MeyouOrderConvert INSTANCE = Mappers.getMapper(MeyouOrderConvert.class);

    static MeyouOrderConvertConvertor instance() {
        return INSTANCE;
    }

    @Mappings({})
    MeyouOrder toMeyouOrder(MeyouOrderDTO meyouOrderDTO);

    @Mappings({})
    MeyouOrderDTO toMeyouOrderDTO(MeyouOrder meyouOrder);

    List<MeyouOrderDTO> toMeyouOrderDTOs(List<MeyouOrder> meyouOrders);

    List<MeyouOrder> toMeyouOrders(List<MeyouOrderDTO> meyouOrderDTOs);
}
