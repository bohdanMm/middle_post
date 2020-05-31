package nulp.middlepost.service.dictionaties.mapper;

import nulp.middlepost.domain.PackageType;
import nulp.middlepost.domain.UserRole;
import org.mapstruct.Mapper;

import java.util.Objects;

@Mapper(componentModel = "spring")
public interface PackageTypeMapper {

    default PackageType fromId(Long id){
        if (Objects.isNull(id)){
            return null;
        }
        PackageType packageType = new PackageType();
        packageType.setId(id);
        return packageType;
    }
}
