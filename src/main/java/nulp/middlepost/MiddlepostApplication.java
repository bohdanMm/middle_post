package nulp.middlepost;

import lombok.RequiredArgsConstructor;
import nulp.middlepost.repository.UserRoleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class MiddlepostApplication {

    private final UserRoleRepository userRoleRepository;

    public static void main(String[] args) {
        SpringApplication.run(MiddlepostApplication.class, args);
    }

//    @PostConstruct
//    public void initialData(){
//        List<UserRole> userRoles = new ArrayList<>();
//        userRoles.add(new UserRole("employee"));
//        userRoles.add(new UserRole("customer"));
//        userRoles.add(new UserRole("admin"));
//        userRoleRepository.saveAll(userRoles);
//    }

}
