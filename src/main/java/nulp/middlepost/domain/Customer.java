package nulp.middlepost.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String passportData;

    @OneToMany(mappedBy = "sender")
    private List<PackageReceiving> sandedPackages;

    @OneToMany(mappedBy = "receiver")
    private List<PackageReceiving> receivedPackages;
}
