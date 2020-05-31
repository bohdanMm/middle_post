package nulp.middlepost.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_id")
public class Customer extends User {

    private String passportData;

    private String phoneNumber;

    @OneToMany(mappedBy = "sender")
    private List<PackageReceiving> sandedPackages = new ArrayList<>();

    @OneToMany(mappedBy = "receiver")
    private List<PackageReceiving> receivedPackages = new ArrayList<>();
}
