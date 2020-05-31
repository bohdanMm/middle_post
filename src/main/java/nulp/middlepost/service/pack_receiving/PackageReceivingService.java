package nulp.middlepost.service.pack_receiving;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nulp.middlepost.domain.Employee;
import nulp.middlepost.domain.PackageReceiving;
import nulp.middlepost.repository.PackageReceivingRepository;
import nulp.middlepost.service.pack.PackageService;
import nulp.middlepost.service.pack.dto.PackageDto;
import nulp.middlepost.service.pack_receiving.dto.PackageReceivingDto;
import nulp.middlepost.service.pack_receiving.dto.PackageReceivingRequest;
import nulp.middlepost.service.pack_receiving.mapper.PackageReceivingMapper;
import nulp.middlepost.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PackageReceivingService {

    private final PackageReceivingRepository packageReceivingRepository;
    private final PackageReceivingMapper packageReceivingMapper;
    private final PackageService packageService;
    private final UserService userService;

    @Transactional
    public PackageReceivingDto create(PackageReceivingRequest packageReceivingRequest) {
        log.debug("Request to create package receiving");

        PackageDto packageDto = packageService.create(packageReceivingRequest);
        packageReceivingRequest.setPack(packageDto.getId());
        PackageReceiving packageReceiving = packageReceivingMapper.toEntity(packageReceivingRequest);
        Employee employee = userService.getEmployeeById(packageReceivingRequest.getEmployee());
        packageReceiving.setPostOfficeFrom(employee.getPostOffice());
        PackageReceiving saved = packageReceivingRepository.save(packageReceiving);

        return packageReceivingMapper.toDto(saved);
    }
}
