package nulp.middlepost.service.pack;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nulp.middlepost.domain.Package;
import nulp.middlepost.repository.PackageRepository;
import nulp.middlepost.service.pack.dto.PackageDto;
import nulp.middlepost.service.pack.mapper.PacMapper;
import nulp.middlepost.service.pack.specification.PackageCriteria;
import nulp.middlepost.service.pack.specification.PackageSpecificationService;
import nulp.middlepost.service.pack_receiving.dto.PackageReceivingRequest;
import nulp.middlepost.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class PackageService {

    private final PackageRepository packageRepository;
    private final PacMapper packageMapper;
    private final PackageSpecificationService specificationService;
    private final UserService userService;

    public PackageDto create(PackageReceivingRequest packageRequest) {
        log.debug("Create new package");

        Package pack = packageMapper.toEntity(packageRequest);
        pack.setOwner(userService.getCustomerByEmail(packageRequest.getSenderEmail()));
        return packageMapper.toDto(packageRepository.save(pack));
    }

    public List<PackageDto> getAll(PackageCriteria criteria) {
        log.debug("Get user packages");

        return packageRepository.findAll(specificationService.createSpecification(criteria))
                .stream()
                .map(packageMapper::toDto)
                .collect(Collectors.toList());
    }
}
