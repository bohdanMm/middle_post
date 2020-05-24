package nulp.middlepost.service.authorization.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class UserDto {

    @NotNull
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private List<String> userRoles;
}
