package nulp.middlepost.service.pack.mapper;

import nulp.middlepost.domain.Package;
import nulp.middlepost.service.authorization.mapper.CustomerMapper;
import nulp.middlepost.service.dictionaties.mapper.DictionariesMapper;
import nulp.middlepost.service.pack.dto.PackageDto;
import nulp.middlepost.service.pack.dto.PackageRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, DictionariesMapper.class})
public interface PackMapper {

    @Mapping(target = "packageType", source = "packageType.name")
    PackageDto toDto(Package pack);

    @Mapping(target = "owner", expression = "java(customerMapper.fromId(request.getOwner()))")
    Package toEntity(PackageRequest request);
}
