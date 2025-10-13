package ru.stroy1click.product.validator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.stroy1click.product.dto.*;
import ru.stroy1click.product.entity.*;
import ru.stroy1click.product.exception.AlreadyExistsException;
import ru.stroy1click.product.service.attribute.AttributeService;
import ru.stroy1click.product.service.category.CategoryService;
import ru.stroy1click.product.service.product.ProductService;
import ru.stroy1click.product.service.product.type.ProductTypeService;
import ru.stroy1click.product.service.subcategory.SubcategoryService;
import ru.stroy1click.product.validator.UpdateValidator;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UpdateValidatorImpl implements UpdateValidator {

    private final CategoryService categoryService;

    private final SubcategoryService subcategoryService;

    private final ProductTypeService productTypeService;

    private final ProductService productService;

    private final AttributeService attributeService;

    @Override
    public void validate(CategoryDto categoryDto){
        Optional<Category> foundCategory = this.categoryService.getByTitle(categoryDto.getTitle());

        if(foundCategory.isPresent() && !Objects.equals(categoryDto.getId(), foundCategory.get().getId())
                && categoryDto.getTitle().equalsIgnoreCase(foundCategory.get().getTitle())){
            throw new AlreadyExistsException("Category with this title already exists");
        }
    }

    @Override
    public void validate(SubcategoryDto subcategoryDto){
        Optional<Subcategory> foundSubcategory= this.subcategoryService.getByTitle(subcategoryDto.getTitle());

        if(foundSubcategory.isPresent() && !Objects.equals(subcategoryDto.getId(), foundSubcategory.get().getId())
                && subcategoryDto.getTitle().equalsIgnoreCase(foundSubcategory.get().getTitle())){
            throw new AlreadyExistsException("Subcategory with this title already exists");
        }
    }

    @Override
    public void validate(ProductTypeDto productTypeDto){
        Optional<ProductType> foundSubcategory= this.productTypeService.getByTitle(productTypeDto.getTitle());

        if(foundSubcategory.isPresent() && !Objects.equals(productTypeDto.getId(), foundSubcategory.get().getId())
                && productTypeDto.getTitle().equalsIgnoreCase(foundSubcategory.get().getTitle())){
            throw new AlreadyExistsException("ProductType with this title already exists");
        }
    }

    @Override
    public void validate(ProductDto productDto){
        Optional<Product> foundProduct = this.productService.getByTitle(productDto.getTitle());

        if(foundProduct.isPresent() && !Objects.equals(productDto.getId(), foundProduct.get().getId())
                && productDto.getTitle().equalsIgnoreCase(foundProduct.get().getTitle())){
            throw new AlreadyExistsException("Product with this title already exists");
        }
    }

    @Override
    public void validate(AttributeDto attributeDto) {
        Optional<Attribute> foundAttribute = this.attributeService.getByTitle(attributeDto.getTitle());

        if(foundAttribute.isPresent() && !Objects.equals(attributeDto.getId(), foundAttribute.get().getId())
                && attributeDto.getTitle().equalsIgnoreCase(foundAttribute.get().getTitle())){
            throw new AlreadyExistsException("Attribute with this title already exists");
        }
    }
}
