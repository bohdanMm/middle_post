package nulp.middlepost.service.post_office.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostOfficeRequest {

    private String name;

    private String street;

    private Integer buildingNumber;

    private Long locality;
}
