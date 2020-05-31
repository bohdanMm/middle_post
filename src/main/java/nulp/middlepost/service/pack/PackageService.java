package nulp.middlepost.service.pack;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nulp.middlepost.domain.Package;
import nulp.middlepost.repository.PackageRepository;
import nulp.middlepost.service.pack.dto.PackageDto;
import nulp.middlepost.service.pack.mapper.PacMapper;
import nulp.middlepost.service.pack_receiving.dto.PackageReceivingRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PackageService {

    private final PackageRepository packageRepository;
    private final PacMapper packageMapper;

    public PackageDto create(PackageReceivingRequest packageRequest) {
        log.debug("Create new package");

        Package pack = packageMapper.toEntity(packageRequest);
        return packageMapper.toDto(packageRepository.save(pack));
    }

    public List<Package> getByUser(Long userId) {
        log.debug("Get user packages");

        packageRepository.findAll()
    }
}
