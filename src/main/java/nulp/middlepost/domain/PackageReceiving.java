package nulp.middlepost.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

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
    private Package aPackage;
}
