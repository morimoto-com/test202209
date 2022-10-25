package base.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class T001Form {

    @NotBlank
    @Size(min = 0, max = 5, message = "{t001.validation.range}")
    private String text1;

    @NotBlank
    @Size(max = 1)
    @Pattern(regexp="[0-1]")
    private String text2;

}
