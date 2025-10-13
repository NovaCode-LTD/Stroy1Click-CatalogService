package ru.stroy1click.product.service.subcategory;

import org.springframework.web.multipart.MultipartFile;
import ru.stroy1click.product.dto.SubcategoryDto;
import ru.stroy1click.product.entity.Subcategory;

import java.util.List;
import java.util.Optional;

public interface SubcategoryService {

    SubcategoryDto get(Integer id);

    void create(SubcategoryDto subcategoryDto);

    void update(Integer id, SubcategoryDto subcategoryDto);

    void delete(Integer id);

    Optional<Subcategory> getByTitle(String title);

    List<SubcategoryDto> getByCategoryId(Integer categoryId);

    void assignImage(Integer id, MultipartFile image);

    void deleteImage(Integer id, String imageName);
}
