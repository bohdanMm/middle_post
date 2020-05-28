package nulp.middlepost.service.pack;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nulp.middlepost.domain.Package;
import nulp.middlepost.repository.PackageRepository;
import nulp.middlepost.service.pack.dto.PackageDto;
import nulp.middlepost.service.pack.dto.PackageRequest;
import nulp.middlepost.service.pack.mapper.PackageMapper;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PackageService {

    private final PackageRepository packageRepository;
    private final PackageMapper packageMapper;

    public PackageDto create(PackageRequest packageRequest) {
        log.debug("Create new package");

        Package pack = packageMapper.toEntity(packageRequest);
        return packageMapper.toDto(packageRepository.save(pack));
    }
}
