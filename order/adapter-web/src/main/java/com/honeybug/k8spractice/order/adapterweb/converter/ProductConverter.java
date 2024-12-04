package com.honeybug.k8spractice.order.adapterweb.converter;

import com.honeybug.k8spractice.order.adapterweb.dto.ProductResponse;
import com.honeybug.k8spractice.order.core.product.vo.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductConverter {

    Product convert(ProductResponse source);

    List<Product> convert(List<ProductResponse> source);
}
