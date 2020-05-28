package nulp.middlepost.service.dictionaries.mapper;

import nulp.middlepost.domain.Packaging;
import org.mapstruct.Mapper;

import java.util.Objects;

@Mapper(componentModel = "spring")
public interface PackagingMapper {

    default Packaging fromId(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        Packaging packaging = new Packaging();
        packaging.setId(id);
        return packaging;
    }
}
