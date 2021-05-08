package com.ecommerce.backend.Ecommerce.dao;

import com.ecommerce.backend.Ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "product",path = "product")
public interface ProductRepository extends JpaRepository<Product,Long> {
}
