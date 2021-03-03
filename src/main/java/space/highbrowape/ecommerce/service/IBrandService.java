package space.highbrowape.ecommerce.service;

import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.request.BrandDto;
import space.highbrowape.ecommerce.dto.request.ProductDto;
import space.highbrowape.ecommerce.entity.Brand;
import space.highbrowape.ecommerce.entity.Product;

import java.util.List;

public interface IBrandService {

    Brand addBrand(BrandDto addBrandDto, MultipartFile file);

    Brand updateBrand(BrandDto updateBrandDto, MultipartFile file);

    Brand getBrand(long id);

    List<Brand> getAllBrands();

    String deleteBrand(Long id);
}
