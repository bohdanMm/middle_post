package nulp.middlepost.service.pack_receiving.dto;

import lombok.Getter;
import lombok.Setter;
import nulp.middlepost.domain.Customer;
import nulp.middlepost.domain.Employee;
import nulp.middlepost.domain.Package;
import nulp.middlepost.domain.Packaging;
import nulp.middlepost.domain.PostOffice;
import nulp.middlepost.service.authorization.dto.UserDto;
import nulp.middlepost.service.pack.dto.PackageDto;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
public class PackageReceivingDto {

    private Long id;

    private UserDto sender;

    private UserDto receiver;

    private LocalDate receivingDate;

    private UserDto employee;

    private PostOffice postOfficeFrom;

    private PostOffice postOfficeTo;

    private Boolean payReceiver;

    private Double deliveryPrice;

    private Packaging packaging;

    private PackageDto packageDto;
}
