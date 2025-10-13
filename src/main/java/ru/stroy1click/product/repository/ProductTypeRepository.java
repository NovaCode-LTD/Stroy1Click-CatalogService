package ru.stroy1click.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stroy1click.product.entity.ProductType;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer>{

    Optional<ProductType> findByTitle(String title);

    List<ProductType> findBySubcategory_Id(Integer subcategoryId);
}
