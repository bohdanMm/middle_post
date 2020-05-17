package nulp.middlepost.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class History {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private PostOffice postOfficeFrom;

    @ManyToOne
    private PostOffice postOfficeTo;

    @ManyToOne
    private Employee employee;

    private Instant receivingDate;

    private Instant sendingDate;

    private Boolean isEndOffice;
}
