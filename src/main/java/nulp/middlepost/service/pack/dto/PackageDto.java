package nulp.middlepost.service.pack.dto;

import lombok.Getter;
import lombok.Setter;
import nulp.middlepost.service.authorization.dto.UserDto;

@Getter
@Setter
public class PackageDto {

    private Long id;

    private Double price;

    private Double weight;

    private String size;

    private UserDto owner;

    private UserDto receiver;

    private String description;

    private String packageType;
}
