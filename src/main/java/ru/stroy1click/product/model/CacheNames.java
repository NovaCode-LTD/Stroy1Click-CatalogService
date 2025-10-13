package ru.stroy1click.product.model;

import lombok.Getter;

@Getter
public enum CacheNames { //TODO
    CATEGORY("category"),
    SUBCATEGORY("subcategory"),
    PRODUCT_TYPE("productType"),
    PRODUCT("product"),
    ALL_CATEGORIES("allCategories");

    private final String cacheName;

    CacheNames(String cacheName) {
        this.cacheName = cacheName;
    }
}
