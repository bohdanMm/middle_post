package nulp.middlepost.service.authorization.mapper;

import nulp.middlepost.domain.Employee;
import nulp.middlepost.service.authorization.dto.UserDto;
import nulp.middlepost.service.authorization.dto.request.EmployeeRequest;
import nulp.middlepost.service.role.mapper.UserRoleMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserRoleMapper.class})
public interface EmployeeMapper {

    Employee toEntity(EmployeeRequest employeeRequest);

    UserDto toUserDto(Employee employee);
}
