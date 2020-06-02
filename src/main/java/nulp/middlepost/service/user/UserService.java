package nulp.middlepost.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nulp.middlepost.domain.Customer;
import nulp.middlepost.domain.Employee;
import nulp.middlepost.exception.EntityNotFoundException;
import nulp.middlepost.repository.CustomerRepository;
import nulp.middlepost.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;

    public Employee getEmployeeById(Long id) {
        log.debug("Get employee by id: {}", id);
        employeeRepository.findAll();

        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id: " + id + " not found"));
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Customer with email" + email + " not found"));
    }
}
