package nulp.middlepost.service.location.mapper;

import nulp.middlepost.domain.Locality;
import nulp.middlepost.service.location.dto.LocalityRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DistrictMapper.class})
public interface LocalityMapper {

    Locality toEntity(LocalityRequest localityRequest);
}
