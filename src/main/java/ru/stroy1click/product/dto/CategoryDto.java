package ru.stroy1click.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable {

    private final static Long SerialVersionUID= 1L;

    private Integer id;

    @NotBlank(message = "{validation.categorydto.image.not_blank}")
    private String image;

    @NotBlank(message = "{validation.categorydto.title.not_blank}")
    @Length(min = 2, max = 40, message = "{validation.categorydto.title.length}")
    private String title;
}
