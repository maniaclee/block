package com.meyou.util;

import com.meyou.dto.MeyouOrderDTO;
import com.meyou.entity.MeyouOrderEntity;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by lipeng on 2018/5/6.
 */
public interface Convert {

    Convert INSTANCE = Mappers.getMapper(Convert.class);

    @Mappings({})
    MeyouOrderDTO toMeyouOrder(MeyouOrderDTO meyouOrderDTO);

    @Mappings({})
    MeyouOrderDTO toMeyouOrderDTO(MeyouOrderEntity meyouOrder);

    List<MeyouOrderDTO> toMeyouOrderDTOs(List<MeyouOrderEntity> meyouOrders);

    List<MeyouOrderEntity> toMeyouOrders(List<MeyouOrderDTO> meyouOrderDTOs);
}
