package nulp.middlepost.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    private Double weight;

    private String size;

    @ManyToOne
    private Customer owner;

    private String description;

    @ManyToOne
    private PackageType packageType;

    @OneToOne(mappedBy = "pack")
    private PackageReceiving packageReceiving;

    @OneToMany(mappedBy = "pac")
    private List<History> history;
}
