package nulp.middlepost.service.history.mapper;

import nulp.middlepost.domain.History;
import nulp.middlepost.service.authorization.mapper.EmployeeMapper;
import nulp.middlepost.service.history.dto.HistoryDto;
import nulp.middlepost.service.history.dto.HistoryRequest;
import nulp.middlepost.service.pack.mapper.PacMapper;
import nulp.middlepost.service.post_office.mapper.PostOfficeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring",
        uses = {
                PostOfficeMapper.class,
                EmployeeMapper.class,
                PacMapper.class
        }, imports = {LocalDateTime.class, ZoneOffset.class})
public interface HistoryMapper {

    History toEntity(HistoryRequest historyRequest);

    @Mapping(target = "receivingDate",
            expression = "java(LocalDateTime.ofInstant(history.getReceivingDate(), ZoneOffset.UTC))")
    HistoryDto toDto(History history);
}
