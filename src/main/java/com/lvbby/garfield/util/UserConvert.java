package com.lvbby.garfield.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import java.util.List;

/**
 * Created by lipeng on 2018/05/06.
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    static UserConvertConvertor instance() {
        return INSTANCE;
    }

    @Mappings({})
    User toUser(UserDTO userDTO);

    @Mappings({})
    UserDTO toUserDTO(User user);

    List<UserDTO> toUserDTOs(List<User> users);

    List<User> toUsers(List<UserDTO> userDTOs);
}
