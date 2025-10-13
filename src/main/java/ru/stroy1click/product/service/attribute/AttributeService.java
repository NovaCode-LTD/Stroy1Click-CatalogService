package ru.stroy1click.product.service.attribute;

import ru.stroy1click.product.dto.AttributeDto;
import ru.stroy1click.product.entity.Attribute;

import java.util.Optional;

public interface AttributeService {

    AttributeDto get(Integer id);

    void create(AttributeDto attributeDto);

    void delete(Integer id);

    void update(Integer id, AttributeDto attributeDto);

    Optional<Attribute> getByTitle(String title);
}
