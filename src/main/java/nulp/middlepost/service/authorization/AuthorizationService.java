package nulp.middlepost.service.authorization;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nulp.middlepost.domain.Customer;
import nulp.middlepost.domain.Employee;
import nulp.middlepost.domain.User;
import nulp.middlepost.exception.EntityNotFoundException;
import nulp.middlepost.repository.CustomerRepository;
import nulp.middlepost.repository.EmployeeRepository;
import nulp.middlepost.repository.UserRepository;
import nulp.middlepost.service.authorization.dto.UserDto;
import nulp.middlepost.service.authorization.dto.CustomerRequest;
import nulp.middlepost.service.authorization.dto.EmployeeRequest;
import nulp.middlepost.service.authorization.dto.LoginRequest;
import nulp.middlepost.service.authorization.mapper.CustomerMapper;
import nulp.middlepost.service.authorization.mapper.EmployeeMapper;
import nulp.middlepost.service.authorization.mapper.UserMapper;
import nulp.middlepost.service.dictionaties.DictionariesService;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthorizationService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final UserMapper userMapper;
    private final EmployeeMapper employeeMapper;
    private final CustomerMapper customerMapper;
    private final DictionariesService userRoleService;

    public UserDto login(LoginRequest loginRequest) {
        log.debug("Log in user with email: {}", loginRequest.getEmail());

        User user = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword())
                .orElseThrow(() -> new EntityNotFoundException("User with email "
                        + loginRequest.getEmail() + " not found"));

        return userMapper.toDto(user);
    }

    public UserDto createEmployee(EmployeeRequest employeeRequest) {
        log.debug("Request to create employee");

        Employee employee = employeeMapper.toEntity(employeeRequest);
        employee.getUserRoles().add(userRoleService.findRoleByName("employee"));

        return employeeMapper.toUserDto(employeeRepository.save(employee));
    }

    public UserDto createCustomer(CustomerRequest customerRequest) {
        log.debug("Request to create customer");

        Customer customer = customerMapper.toEntity(customerRequest);
        customer.getUserRoles().add(userRoleService.findRoleByName("customer"));

        return customerMapper.toUserDto(customerRepository.save(customer));
    }
}
