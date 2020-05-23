package nulp.middlepost.service.authorization.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginRequest {

    @NotNull
    private String email;

    @NotNull
    private String password;
}
