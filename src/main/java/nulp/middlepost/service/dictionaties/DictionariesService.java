package nulp.middlepost.service.dictionaties;

import lombok.RequiredArgsConstructor;
import nulp.middlepost.domain.PackageType;
import nulp.middlepost.domain.Packaging;
import nulp.middlepost.domain.UserRole;
import nulp.middlepost.exception.EntityNotFoundException;
import nulp.middlepost.repository.PackageTypeRepository;
import nulp.middlepost.repository.PackagingRepository;
import nulp.middlepost.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DictionariesService {

    private final UserRoleRepository userRoleRepository;
    private final PackageTypeRepository packageTypeRepository;
    private final PackagingRepository packagingRepository;

    public UserRole findRoleByName(String roleName) {
        return userRoleRepository.findByName(roleName)
                .orElseThrow(() -> new EntityNotFoundException("User role with name: " + roleName + " not found"));
    }

    public List<PackageType> getAllPackageTypes() {
        return packageTypeRepository.findAll();
    }

    public List<Packaging> getAllPackagingTypes() {
        return packagingRepository.findAll();
    }
}
