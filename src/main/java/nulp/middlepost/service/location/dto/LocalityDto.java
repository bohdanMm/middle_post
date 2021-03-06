package nulp.middlepost.service.location.dto;

import lombok.Getter;
import lombok.Setter;
import nulp.middlepost.service.location.dto.DistrictDto;

@Getter
@Setter
public class LocalityDto {

    private Long id;

    private String name;

    private DistrictDto district;
}
