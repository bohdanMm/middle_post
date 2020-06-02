package nulp.middlepost.service.pack.mapper;

import nulp.middlepost.domain.Package;
import nulp.middlepost.service.authorization.mapper.CustomerMapper;
import nulp.middlepost.service.dictionaties.mapper.PackageTypeMapper;
import nulp.middlepost.service.pack.dto.PackageDto;
import nulp.middlepost.service.pack_receiving.dto.PackageReceivingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Objects;

@Mapper(componentModel = "spring", uses = {PackageTypeMapper.class, CustomerMapper.class})
public interface PacMapper {

    @Mapping(target = "packageType", source = "packageType.name")
    @Mapping(target = "receiver", source = "packageReceiving.receiver")
    PackageDto toDto(Package pac);

    Package toEntity(PackageReceivingRequest packageRequest);

    default Package fromId(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        Package pack = new Package();
        pack.setId(id);
        return pack;
    }

}
