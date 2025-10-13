package ru.stroy1click.product.service.product.type;


import org.springframework.web.multipart.MultipartFile;
import ru.stroy1click.product.dto.ProductTypeDto;
import ru.stroy1click.product.entity.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductTypeService {

    ProductTypeDto get(Integer id);

    void create(ProductTypeDto productTypeDto);

    void update(Integer id, ProductTypeDto productTypeDto);

    void delete(Integer id);

    Optional<ProductType> getByTitle(String title);

    List<ProductTypeDto> getBySubcategory(Integer subcategoryId);

    void assignImage(Integer id, MultipartFile image);

    void deleteImage(Integer id, String link);
}
