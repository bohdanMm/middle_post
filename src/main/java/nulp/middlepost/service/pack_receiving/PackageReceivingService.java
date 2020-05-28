package nulp.middlepost.service.pack_receiving;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nulp.middlepost.domain.PackageReceiving;
import nulp.middlepost.repository.PackageReceivingRepository;
import nulp.middlepost.service.pack_receiving.dto.PackageReceivingDto;
import nulp.middlepost.service.pack_receiving.dto.PackageReceivingRequest;
import nulp.middlepost.service.pack_receiving.mapper.PackageReceivingMapper;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PackageReceivingService {

    private final PackageReceivingRepository packageReceivingRepository;
    private final PackageReceivingMapper packageReceivingMapper;

    public PackageReceivingDto create(PackageReceivingRequest packageReceivingRequest) {
        log.debug("Request to create package receiving");

        PackageReceiving packageReceiving = packageReceivingMapper.toEntity(packageReceivingRequest);
        PackageReceiving saved = packageReceivingRepository.save(packageReceiving);

        return packageReceivingMapper.toDto(saved);
    }
}
