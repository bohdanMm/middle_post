package nulp.middlepost.service.history.dto;

import lombok.Getter;
import lombok.Setter;
import nulp.middlepost.service.authorization.dto.UserDto;
import nulp.middlepost.service.pack.dto.PackageDto;
import nulp.middlepost.service.post_office.dto.PostOfficeDto;

import java.time.Instant;

@Getter
@Setter
public class HistoryDto {

    private Long id;

    private PostOfficeDto postOffice;

    private UserDto employee;

    private Instant receivingDate;

    private Boolean isEndOffice;

    private PackageDto pac;
}
