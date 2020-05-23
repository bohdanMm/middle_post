package nulp.middlepost.service.role.mapper;

import nulp.middlepost.domain.UserRole;
import nulp.middlepost.service.role.dto.UserRoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    UserRoleDto toDto(UserRole userRole);
}
