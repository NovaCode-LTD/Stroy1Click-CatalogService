package ru.stroy1click.product.dto;

import jakarta.validation.constraints.Min;
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
public class ProductTypeDto implements Serializable {

    private final static Long SerialVersionUID= 1L;

    private Integer id;

    @NotNull(message = "{validation.producttypedto.subcategory_id.not_null}")
    @Min(value = 1, message = "{validation.producttypedto.subcategory_id.min}")
    private Integer subcategoryId;

    @NotBlank(message = "{validation.producttypedto.image.not_blank}")
    private String image;

    @NotBlank(message = "{validation.producttypedto.title.not_blank}")
    @Length(min = 2, max = 40, message = "{validation.producttypedto.title.length}")
    private String title;
}
