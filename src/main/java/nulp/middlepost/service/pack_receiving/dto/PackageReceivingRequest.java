package nulp.middlepost.service.pack_receiving.dto;

import lombok.Getter;
import lombok.Setter;
import nulp.middlepost.service.post_office.dto.PostOfficeDto;

import java.time.Instant;

@Getter
@Setter
public class PackageReceivingRequest {

    private Long id;

    private Long sender;

    private Long receiver;

    private Instant receivingDate = Instant.now();

    private Long employee;

    private PostOfficeDto postOfficeFrom;

    private PostOfficeDto postOfficeTo;

    private Boolean payReceiver;

    private Double deliveryPrice;

    private Long packaging;

    private Long pack;
}
