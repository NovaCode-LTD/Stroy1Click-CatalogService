package ru.stroy1click.product.service.product.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stroy1click.product.dto.ProductDto;
import ru.stroy1click.product.exception.ValidationException;
import ru.stroy1click.product.repository.ProductRepository;
import ru.stroy1click.product.service.product.ProductPaginationService;
import ru.stroy1click.product.service.product.ProductService;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Stream;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductPaginationServiceImpl implements ProductPaginationService {

    private final ProductRepository productRepository;

    private final ProductService productService;

    private final MessageSource messageSource;

    @Override
    public List<ProductDto> getProducts(Integer categoryId,
                                        Integer subcategoryId,
                                        Integer productType,
                                        Pageable pageable){
        Page<Integer> productIds;

        if (Stream.of(categoryId, subcategoryId, productType).filter(Objects::nonNull).count() > 1) {
            throw new ValidationException("Можно указать только один фильтр: categoryId, subcategoryId или productType");
        } else if (categoryId != null) {
            productIds = productRepository.findProductIdsByCategory_Id(categoryId, pageable);
        } else if (subcategoryId != null) {
            productIds = productRepository.findProductIdsBySubcategory_Id(subcategoryId, pageable);
        } else if (productType != null) {
            productIds = productRepository.findProductIdsByProductType_Id(productType, pageable);
        } else {
            throw new ValidationException(
                    this.messageSource.getMessage(
                            "",
                            null,
                            Locale.getDefault()
                    )
            );
        }

        return productIds.stream()
                .map(this.productService::get)
                .toList();
    }
}