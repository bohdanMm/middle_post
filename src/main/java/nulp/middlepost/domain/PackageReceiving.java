package nulp.middlepost.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
public class PackageReceiving {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer sender;

    @ManyToOne
    private Customer receiver;

    private Instant receivingDate;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private PostOffice postOfficeFrom;

    @ManyToOne
    private PostOffice postOfficeTo;

    private Boolean payReceiver;

    private Double deliveryPrice;

    @ManyToOne
    private Packaging packaging;

    @OneToOne
    private Package pack;
}
