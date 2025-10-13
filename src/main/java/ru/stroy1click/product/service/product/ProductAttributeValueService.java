package ru.stroy1click.product.service.product;

import ru.stroy1click.product.dto.ProductAttributeValueDto;

import java.util.List;

public interface ProductAttributeValueService {

    ProductAttributeValueDto get(Integer id);

    List<ProductAttributeValueDto> getAllByProductId(Integer id);

    void create(ProductAttributeValueDto productAttributeValueDto);

    void delete(Integer id);

    void update(Integer id, ProductAttributeValueDto productAttributeValueDto);

}
