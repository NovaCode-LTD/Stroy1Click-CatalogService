package ru.stroy1click.product.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import ru.stroy1click.product.entity.Product;
import ru.stroy1click.product.entity.ProductAttributeValue;
import ru.stroy1click.product.model.ProductAttributeFilter;

import java.util.Map;

public class ProductSpecification {

    public static Specification<Product> filterByAttributes(ProductAttributeFilter filter) {
        return (root, query, cb) -> {
            query.distinct(true); // чтобы не дублировались продукты из join

            Predicate predicate = cb.conjunction();

            if (filter.getAttributes() != null && !filter.getAttributes().isEmpty()) {
                Join<Product, ProductAttributeValue> join = root.join("productAttributeValue");

                for (Map.Entry<String, String> entry : filter.getAttributes().entrySet()) {
                    Predicate attrPredicate = cb.and(
                            cb.equal(join.get("attribute").get("title"), entry.getKey()),
                            cb.equal(join.get("value"), entry.getValue())
                    );
                    predicate = cb.and(predicate, attrPredicate);
                }
            }

            return predicate;
        };
    }

}
