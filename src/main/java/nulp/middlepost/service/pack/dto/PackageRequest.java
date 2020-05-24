package nulp.middlepost.service.pack.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageRequest {

    private Long id;

    private Double price;

    private Double weight;

    private String size;

    private Long owner;

    private String description;

    private Long packageType;
}
