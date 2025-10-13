package ru.stroy1click.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageDto implements Serializable {

    private final static long SerialVersionUID= 1L;

    private Integer id;

    private Integer productId;

    private String link;
}
