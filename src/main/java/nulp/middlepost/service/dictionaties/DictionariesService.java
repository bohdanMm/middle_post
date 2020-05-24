package nulp.middlepost.service.dictionaties;

import lombok.RequiredArgsConstructor;
import nulp.middlepost.domain.UserRole;
import nulp.middlepost.exception.EntityNotFoundException;
import nulp.middlepost.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DictionariesService {

    private final UserRoleRepository userRoleRepository;

    public UserRole findRoleByName(String roleName) {
        return userRoleRepository.findByName(roleName)
                .orElseThrow(() -> new EntityNotFoundException("User role with name: " + roleName + " not found"));
    }
}
