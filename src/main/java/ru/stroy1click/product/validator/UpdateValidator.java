package ru.stroy1click.product.validator;

import ru.stroy1click.product.dto.*;

public interface UpdateValidator {

    void validate(CategoryDto categoryDto);

    void validate(SubcategoryDto subcategoryDto);

    void validate(ProductTypeDto productTypeDto);

    void validate(ProductDto productDto);

    void validate(AttributeDto attributeDto);
}
