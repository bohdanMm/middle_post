package nulp.middlepost.service.authorization.mapper;

import nulp.middlepost.domain.Employee;
import nulp.middlepost.domain.UserRole;
import nulp.middlepost.service.authorization.dto.EmployeeRequest;
import nulp.middlepost.service.authorization.dto.UserDto;
import nulp.middlepost.service.dictionaties.mapper.PackageTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {PackageTypeMapper.class}, imports = {UserRole.class, Collectors.class})
public interface EmployeeMapper {

    Employee toEntity(EmployeeRequest employeeRequest);

    @Mapping(target = "userRole", source = "userRole.name")
    UserDto toUserDto(Employee employee);

    default Employee fromId(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }

}
