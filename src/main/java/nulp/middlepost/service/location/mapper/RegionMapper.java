package nulp.middlepost.service.location.mapper;

import nulp.middlepost.domain.Region;
import nulp.middlepost.service.location.dto.RegionDto;
import nulp.middlepost.service.location.dto.RegionRequest;
import org.mapstruct.Mapper;

import java.util.Objects;

@Mapper(componentModel = "spring")
public interface RegionMapper {

    Region toEntity(RegionRequest regionRequest);

    RegionDto toDto(Region region);

    default Region fromId(Long id){
        if (Objects.isNull(id)){
            return null;
        }
        Region region = new Region();
        region.setId(id);
        return region;
    }
}
