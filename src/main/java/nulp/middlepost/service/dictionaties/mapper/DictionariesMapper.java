package nulp.middlepost.service.dictionaties.mapper;

import nulp.middlepost.domain.PackageType;
import nulp.middlepost.domain.UserRole;
import org.mapstruct.Mapper;

import java.util.Objects;

@Mapper(componentModel = "spring")
public interface DictionariesMapper {

    default PackageType packageTypeFromId(Long id){
        if (Objects.isNull(id)){
            return null;
        }
        PackageType packageType = new PackageType();
        packageType.setId(id);
        return packageType;
    }
}
