package nulp.middlepost.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Entity
@Getter
@Setter
public class History {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private PostOffice postOffice;

    @ManyToOne
    private Employee employee;

    private Instant receivingDate;

    private Instant sendingDate;

    private Boolean isEndOffice;
}
