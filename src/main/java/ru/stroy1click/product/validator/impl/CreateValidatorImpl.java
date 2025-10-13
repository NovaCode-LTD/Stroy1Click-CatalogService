package ru.stroy1click.product.validator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.stroy1click.product.dto.*;
import ru.stroy1click.product.exception.AlreadyExistsException;
import ru.stroy1click.product.service.attribute.AttributeService;
import ru.stroy1click.product.service.category.CategoryService;
import ru.stroy1click.product.service.product.ProductService;
import ru.stroy1click.product.service.product.type.ProductTypeService;
import ru.stroy1click.product.service.subcategory.SubcategoryService;
import ru.stroy1click.product.validator.CreateValidator;

@Component
@RequiredArgsConstructor
public class CreateValidatorImpl implements CreateValidator {

    private final CategoryService categoryService;

    private final SubcategoryService subcategoryService;

    private final ProductTypeService productTypeService;

    private final ProductService productService;

    private final AttributeService attributeService;

    @Override
    public void validate(CategoryDto categoryDto){
        if(this.categoryService.getByTitle(categoryDto.getTitle()).isPresent()){
            throw new AlreadyExistsException("Category with this title already exists");
        }
    }

    @Override
    public void validate(SubcategoryDto subcategoryDto){
        if(this.subcategoryService.getByTitle(subcategoryDto.getTitle()).isPresent()){
            throw new AlreadyExistsException("Subcategory with this title already exists");
        }
    }

    @Override
    public void validate(ProductTypeDto productTypeDto){
        if(this.productTypeService.getByTitle(productTypeDto.getTitle()).isPresent()){
            throw new AlreadyExistsException("ProductType with this title already exists");
        }
    }

    @Override
    public void validate(ProductDto productDto){
        if(this.productService.getByTitle(productDto.getTitle()).isPresent()){
            throw new AlreadyExistsException("Product with this title already exists");
        }
    }

    @Override
    public void validate(AttributeDto attributeDto) {
        if(this.attributeService.getByTitle(attributeDto.getTitle()).isPresent()){
            throw new AlreadyExistsException("Attribute with this title already exists");
        }
    }
}
