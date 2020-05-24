package nulp.middlepost.service.location;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nulp.middlepost.domain.District;
import nulp.middlepost.domain.Locality;
import nulp.middlepost.domain.Region;
import nulp.middlepost.repository.DistrictRepository;
import nulp.middlepost.repository.LocalityRepository;
import nulp.middlepost.repository.RegionRepository;
import nulp.middlepost.service.location.dto.DistrictRequest;
import nulp.middlepost.service.location.dto.LocalityRequest;
import nulp.middlepost.service.location.dto.RegionRequest;
import nulp.middlepost.service.location.mapper.DistrictMapper;
import nulp.middlepost.service.location.mapper.LocalityMapper;
import nulp.middlepost.service.location.mapper.RegionMapper;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LocationService {

    private final DistrictRepository districtRepository;
    private final RegionRepository regionRepository;
    private final LocalityRepository localityRepository;
    private final DistrictMapper districtMapper;
    private final LocalityMapper localityMapper;
    private final RegionMapper regionMapper;

    public String createDistrict(DistrictRequest districtRequest){
        log.debug("Create district");

        District district = districtMapper.toEntity(districtRequest);
        return districtRepository.save(district).getName();
    }

    public String createRegion(RegionRequest regionRequest){
        log.debug("Create region");

        Region region = regionMapper.toEntity(regionRequest);
        return regionRepository.save(region).getName();
    }

    public String createLocality(LocalityRequest localityRequest){
        log.debug("Create locality");

        Locality locality = localityMapper.toEntity(localityRequest);
        return localityRepository.save(locality).getName();
    }
}
