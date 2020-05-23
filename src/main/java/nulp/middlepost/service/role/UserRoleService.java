package nulp.middlepost.service.role;

import lombok.RequiredArgsConstructor;
import nulp.middlepost.domain.UserRole;
import nulp.middlepost.exception.EntityNotFoundException;
import nulp.middlepost.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRole findByName(String roleName) {
        return userRoleRepository.findByName(roleName)
                .orElseThrow(() -> new EntityNotFoundException("User role with name: " + roleName + " not found"));
    }
}
