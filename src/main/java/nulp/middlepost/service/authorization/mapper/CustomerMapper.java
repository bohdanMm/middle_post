package nulp.middlepost.service.authorization.mapper;

import nulp.middlepost.domain.Customer;
import nulp.middlepost.service.authorization.dto.UserDto;
import nulp.middlepost.service.authorization.dto.request.CustomerRequest;
import nulp.middlepost.service.role.mapper.UserRoleMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserRoleMapper.class})
public interface CustomerMapper {

    Customer toEntity(CustomerRequest customerRequest);

    UserDto toUserDto(Customer customer);
}
