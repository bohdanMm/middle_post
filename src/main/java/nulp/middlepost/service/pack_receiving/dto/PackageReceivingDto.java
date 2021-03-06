package nulp.middlepost.service.pack_receiving.dto;

import lombok.Getter;
import lombok.Setter;
import nulp.middlepost.service.authorization.dto.UserDto;
import nulp.middlepost.service.pack.dto.PackageDto;
import nulp.middlepost.service.post_office.dto.PostOfficeDto;

import java.time.Instant;

@Getter
@Setter
public class PackageReceivingDto {

    private Long id;

    private UserDto sender;

    private UserDto receiver;

    private Instant receivingDate;

    private UserDto employee;

    private PostOfficeDto postOfficeFrom;

    private PostOfficeDto postOfficeTo;

    private Boolean payReceiver;

    private Double deliveryPrice;

    private String packaging;

    private PackageDto packageDto;
}
