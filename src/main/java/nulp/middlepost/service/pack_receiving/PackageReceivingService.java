package nulp.middlepost.service.pack_receiving;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nulp.middlepost.repository.PackageReceivingRepository;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PackageReceivingService {

    private final PackageReceivingRepository packageReceivingRepository;

}
