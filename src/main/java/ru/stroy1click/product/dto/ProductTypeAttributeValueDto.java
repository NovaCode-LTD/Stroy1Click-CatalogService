package ru.stroy1click.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeAttributeValueDto implements Serializable {

    private final static Long SerialVersionUID= 1L;

    private Integer id;

    private Integer attributeId;

    private Integer productTypeId;

    private String value;
}
