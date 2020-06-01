package nulp.middlepost.service.location.mapper;

import nulp.middlepost.domain.District;
import nulp.middlepost.service.location.dto.DistrictDto;
import nulp.middlepost.service.location.dto.DistrictRequest;
import org.mapstruct.Mapper;

import java.util.Objects;

@Mapper(componentModel = "spring", uses = {RegionMapper.class})
public interface DistrictMapper {

    District toEntity(DistrictRequest districtRequest);

    DistrictDto toDto(District district);

    default District fromId(Long id){
        if (Objects.nonNull(id)){
            return null;
        }
        District district = new District();
        district.setId(id);
        return district;
    }
}
