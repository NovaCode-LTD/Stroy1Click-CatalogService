package ru.stroy1click.product.service.product.type;

import ru.stroy1click.product.dto.ProductTypeAttributeValueDto;

import java.util.List;

public interface ProductTypeAttributeValueService {

    ProductTypeAttributeValueDto get(Integer id);

    List<ProductTypeAttributeValueDto> getAllByProductId(Integer id);

    void create(ProductTypeAttributeValueDto productTypeAttributeValueDto);

    void delete(Integer id);

    void update(Integer id, ProductTypeAttributeValueDto productTypeAttributeValueDto);

}
