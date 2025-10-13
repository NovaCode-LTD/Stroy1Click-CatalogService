package ru.stroy1click.product.service.category;

import org.springframework.web.multipart.MultipartFile;
import ru.stroy1click.product.dto.CategoryDto;
import ru.stroy1click.product.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryDto get(Integer id);

    List<CategoryDto> getAll();

    void create(CategoryDto categoryDto);

    void update(Integer id, CategoryDto categoryDto);

    void delete(Integer id);

    Optional<Category> getByTitle(String title);

    void assignImage(Integer id, MultipartFile image);

    void deleteImage(Integer id, String imageName);
}
