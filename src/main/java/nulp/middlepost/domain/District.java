package nulp.middlepost.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "district")
@Getter
@Setter
public class District {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Region region;

    @OneToMany(mappedBy = "district")
    private List<Locality> localities = new ArrayList<>();
}
