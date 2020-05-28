package nulp.middlepost.service.location.mapper;

import nulp.middlepost.domain.Locality;
import nulp.middlepost.service.location.dto.LocalityDto;
import nulp.middlepost.service.location.dto.LocalityRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Objects;

@Mapper(componentModel = "spring", uses = {DistrictMapper.class})
public interface LocalityMapper {

    @Mapping(target = "regionName", source = "district.region.name")
    @Mapping(target = "districtName", source = "district.name")
    LocalityDto toDto(Locality locality);

    Locality toEntity(LocalityRequest localityRequest);

    default Locality fromId(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        Locality locality = new Locality();
        locality.setId(id);
        return locality;
    }
}
