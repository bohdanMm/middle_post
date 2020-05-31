package nulp.middlepost.service.authorization.mapper;

import nulp.middlepost.domain.Customer;
import nulp.middlepost.domain.UserRole;
import nulp.middlepost.service.authorization.dto.UserDto;
import nulp.middlepost.service.authorization.dto.CustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {UserRole.class, Collectors.class})
public interface CustomerMapper {

    Customer toEntity(CustomerRequest customerRequest);

    @Mapping(target = "userRole", source = "userRole.name")
    UserDto toUserDto(Customer customer);

    default Customer fromId(Long id){
        if (Objects.isNull(id)){
            return null;
        }
        Customer customer = new Customer();
        customer.setId(id);
        return customer;
    }
}
