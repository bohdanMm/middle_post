package nulp.middlepost.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_id")
public class Employee extends User {

    @ManyToOne
    private PostOffice postOffice;

    @ManyToOne
    private Position position;
}
