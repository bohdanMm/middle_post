package nulp.middlepost.service.authorization.mapper;

import nulp.middlepost.domain.User;
import nulp.middlepost.domain.UserRole;
import nulp.middlepost.service.authorization.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {UserRole.class, Collectors.class})
public interface UserMapper {

    @Mapping(target = "userRoles", expression = "java(user.getUserRoles().stream().map(UserRole::getName).collect(Collectors.toList()))")
    UserDto toDto(User user);

    default User fromId(Long id){
        if (Objects.isNull(id)){
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }
}
