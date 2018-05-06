package com.lvbby.garfield.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import java.util.List;

/**
 * Created by lipeng on 2018/05/06.
 */
@Mapper
public interface MeyouUserConvert {

    MeyouUserConvert INSTANCE = Mappers.getMapper(MeyouUserConvert.class);

    static MeyouUserConvertConvertor instance() {
        return INSTANCE;
    }

    @Mappings({})
    MeyouUser toMeyouUser(MeyouUserDTO meyouUserDTO);

    @Mappings({})
    MeyouUserDTO toMeyouUserDTO(MeyouUser meyouUser);

    List<MeyouUserDTO> toMeyouUserDTOs(List<MeyouUser> meyouUsers);

    List<MeyouUser> toMeyouUsers(List<MeyouUserDTO> meyouUserDTOs);
}
