package ru.stroy1click.product.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.stroy1click.product.dto.ProductAttributeValueDto;
import ru.stroy1click.product.entity.ProductAttributeValue;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductAttributeValueMapper implements Mappable<ProductAttributeValue, ProductAttributeValueDto>{

    private final ModelMapper modelMapper;

    @Override
    public ProductAttributeValue toEntity(ProductAttributeValueDto productAttributeValueDto) {
        return this.modelMapper.map(productAttributeValueDto, ProductAttributeValue.class);
    }

    @Override
    public ProductAttributeValueDto toDto(ProductAttributeValue productAttributeValue) {
        return this.modelMapper.map(productAttributeValue, ProductAttributeValueDto.class);
    }

    @Override
    public List<ProductAttributeValueDto> toDto(List<ProductAttributeValue> e) {
        return e.stream()
                .map(productAttributeValue -> this.modelMapper.map(productAttributeValue, ProductAttributeValueDto.class))
                .toList();
    }
}
