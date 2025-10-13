package ru.stroy1click.product.cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CacheClear {

    private final RedissonClient redissonClient;

    public void clearSubcategoriesOfCategory(Integer categoryId){
        log.info("clearSubcategoriesOfCertainCategory {}", categoryId);
        deleteCache("subcategoriesOfCategory",categoryId);
    }

    public void clearProductsTypesOfSubcategory(Integer subcategoryId) {
        log.info("clearProductsTypesOfCertainSubcategory {}", subcategoryId);
        deleteCache("productsTypesOfSubcategory",subcategoryId);
    }

    public void clearPaginationOfProductsByCategory(Integer categoryId){
        log.info("clearPaginationOfProductsByCategory {}", categoryId);
        deleteCache("clearPaginationOfProductsByCategory", categoryId);
    }

    public void clearPaginationOfProductsBySubcategory(Integer subcategoryId){
        log.info("clearPaginationOfProductsBySubcategory {}", subcategoryId);
        deleteCache("clearPaginationOfProductsBySubcategory", subcategoryId);
    }

    public void clearPaginationOfProductsByProductType(Integer productTypeId){
        log.info("clearPaginationOfProductsByProductType {}", productTypeId);
        deleteCache("clearPaginationOfProductsByProductType", productTypeId);
    }

    public void clearAllProductAttributeValuesByProductId(Integer productId){
        log.info("allProductAttributeValuesByProductTypeId {}", productId);
        deleteCache("allProductAttributeValuesByProductId", productId);
    }

    public void clearAllProductTypeAttributeValuesByProductTypeId(Integer productTypeId){
        log.info("clearAllProductTypeAttributeValuesByProductTypeId {}", productTypeId);
        deleteCache("allProductTypeAttributeValuesByProductTypeId", productTypeId);
    }

    public void clearProductImages(Integer productId){
        log.info("clearProductImages {productId}");
        deleteCache("productImages", productId);
    }

    private void deleteCache(String key, Integer value){
        RMapCache<Integer, Object> mapCache = this.redissonClient.getMapCache(key);
        mapCache.fastRemove(value);
    }
}