package nulp.middlepost.service.pack.mapper;

import nulp.middlepost.domain.Package;
import nulp.middlepost.service.authorization.mapper.CustomerMapper;
import nulp.middlepost.service.dictionaties.mapper.DictionariesMapper;
import nulp.middlepost.service.pack.dto.PackageDto;
import nulp.middlepost.service.pack.dto.PackageRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Objects;

@Mapper(componentModel = "spring", uses = {DictionariesMapper.class, CustomerMapper.class})
public interface PackageMapper {

    @Mapping(target = "packageType", source = "packageType.name")
    PackageDto toDto(Package pac);

    Package toEntity(PackageRequest packageRequest);

    default Package fromId(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        Package pack = new Package();
        pack.setId(id);
        return pack;
    }

}
