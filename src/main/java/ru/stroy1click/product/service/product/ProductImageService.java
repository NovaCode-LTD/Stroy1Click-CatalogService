package ru.stroy1click.product.service.product;

import ru.stroy1click.product.dto.ProductImageDto;

import java.util.List;

public interface ProductImageService {

    List<ProductImageDto> getAllByProductId(Integer productId);

    void create(List<ProductImageDto> list);

    void create(ProductImageDto productImageDto);

    void update(Integer id, ProductImageDto productImageDto);

    void delete(String link);
}
