package nulp.middlepost.service.history.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import nulp.middlepost.service.authorization.dto.UserDto;
import nulp.middlepost.service.pack.dto.PackageDto;
import nulp.middlepost.service.post_office.dto.PostOfficeDto;

import java.time.LocalDateTime;

@Getter
@Setter
public class HistoryDto {

    private Long id;

    private PostOfficeDto postOffice;

    private UserDto employee;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime receivingDate;

    private Boolean isEndOffice;

    private PackageDto pac;
}
