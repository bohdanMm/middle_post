package nulp.middlepost.service.post_office.dto;

import lombok.Getter;
import lombok.Setter;
import nulp.middlepost.service.location.dto.LocalityDto;

@Getter
@Setter
public class PostOfficeDto {

    private Long id;

    private String name;

    private String street;

    private Integer buildingNumber;

    private LocalityDto locality;
}
