package nulp.middlepost.service.authorization.mapper;

import nulp.middlepost.domain.User;
import nulp.middlepost.service.authorization.dto.UserDto;
import nulp.middlepost.service.role.mapper.UserRoleMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserRoleMapper.class})
public interface UserMapper {

    UserDto toDto(User user);
}
