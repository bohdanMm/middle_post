package nulp.middlepost.service.authorization.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EmployeeRequest extends UserRequest {

    @NotNull
    private Long postOfficeId;

    @NotNull
    private Long positionId;
}
