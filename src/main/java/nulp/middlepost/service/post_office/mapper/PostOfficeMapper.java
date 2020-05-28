package nulp.middlepost.service.post_office.mapper;

import nulp.middlepost.domain.PostOffice;
import nulp.middlepost.service.location.mapper.LocalityMapper;
import nulp.middlepost.service.post_office.dto.PostOfficeDto;
import nulp.middlepost.service.post_office.dto.PostOfficeRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LocalityMapper.class})
public interface PostOfficeMapper {

    PostOfficeDto toDto(PostOffice postOffice);

    PostOffice toEntity(PostOfficeRequest postOfficeRequest);
}
