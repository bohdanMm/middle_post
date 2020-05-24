package nulp.middlepost.service.authorization.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CustomerRequest extends UserRequest {

    @NotNull
    private String passportData;
}
