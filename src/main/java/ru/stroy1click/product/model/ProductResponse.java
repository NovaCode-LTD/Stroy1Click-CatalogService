package ru.stroy1click.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stroy1click.product.dto.ProductAttributeValueDto;
import ru.stroy1click.product.dto.ProductDto;
import ru.stroy1click.product.dto.ProductImageDto;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private ProductDto productDto;

    private List<ProductImageDto> images;

    private List<ProductAttributeValueDto> values;
}
