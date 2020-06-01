package nulp.middlepost.service.post_office.dto;

import lombok.Getter;
import lombok.Setter;
import nulp.middlepost.service.location.dto.LocalityDto;

import java.time.Instant;

@Getter
@Setter
public class PostOfficeDto {

    private Long id;

    private String name;

    private String street;

    private Integer buildingNumber;

    private LocalityDto locality;

    private Instant receivingDate;

    private Boolean isEndOffice;
}
