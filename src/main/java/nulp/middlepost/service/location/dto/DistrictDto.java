package nulp.middlepost.service.location.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistrictDto {

    private Long id;

    private String name;

    private RegionDto region;
}
