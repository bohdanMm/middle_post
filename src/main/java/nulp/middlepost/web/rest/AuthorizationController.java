package nulp.middlepost.web.rest;

import lombok.RequiredArgsConstructor;
import nulp.middlepost.service.authorization.AuthorizationService;
import nulp.middlepost.service.authorization.dto.UserDto;
import nulp.middlepost.service.authorization.dto.request.CustomerRequest;
import nulp.middlepost.service.authorization.dto.request.EmployeeRequest;
import nulp.middlepost.service.authorization.dto.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @PostMapping("/create/employee")
    public ResponseEntity<UserDto> createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        return ResponseEntity.ok().body(authorizationService.createEmployee(employeeRequest));
    }

    @PostMapping("/create/customer")
    public ResponseEntity<UserDto> createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.ok().body(authorizationService.createCustomer(customerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> logIn(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok().body(authorizationService.login(loginRequest));
    }
}
