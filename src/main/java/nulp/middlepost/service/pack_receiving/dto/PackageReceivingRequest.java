package nulp.middlepost.service.pack_receiving.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class PackageReceivingRequest {

    private Long id;

    private String senderEmail;

    private String receiverEmail;

    private Instant receivingDate = Instant.now();

    private Long employee;

    private Long postOfficeFrom;

    private Long postOfficeTo;

    private Boolean payReceiver;

    private Double deliveryPrice;

    private Long packaging;

    private Long pack;

    private Double price;

    private Double weight;

    private String size;

    private String description;

    private Long packageType;
}
