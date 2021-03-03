package space.highbrowape.ecommerce.service;

import space.highbrowape.ecommerce.dto.request.ProductDto;
import space.highbrowape.ecommerce.entity.Product;

import java.util.List;

public interface IProductService {
    Product addProduct(ProductDto addProductDto);

    Product updateProduct(ProductDto updateProductDto);

    String deleteProduct(Long id);

    List<Product> getAllProducts();

    Product getProduct(long id);
}
