package com.ecommerce.backend.Ecommerce.config;

import com.ecommerce.backend.Ecommerce.entity.Product;
import com.ecommerce.backend.Ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] UnSupportedMethods={HttpMethod.DELETE,HttpMethod.PUT,HttpMethod.POST};
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(UnSupportedMethods)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(UnSupportedMethods)));
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(UnSupportedMethods)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(UnSupportedMethods));
    }
}
