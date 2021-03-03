package space.highbrowape.ecommerce.service;


import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import space.highbrowape.ecommerce.dto.request.ProductDto;
import space.highbrowape.ecommerce.entity.*;
import space.highbrowape.ecommerce.exception.BrandNotFoundException;
import space.highbrowape.ecommerce.exception.CategoryNotFoundException;
import space.highbrowape.ecommerce.exception.ProductAlreadyExistException;
import space.highbrowape.ecommerce.exception.ProductNotFoundException;
import space.highbrowape.ecommerce.repository.BrandRepository;
import space.highbrowape.ecommerce.repository.CategoryRepository;
import space.highbrowape.ecommerce.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl  implements IProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    CategoryRepository categoryRepository;


    ModelMapper mapper= new ModelMapper();
    @Override
    public Product addProduct(ProductDto addProductDto) {
        Optional<Brand> brandOptional= brandRepository.findById(addProductDto.getBrandId());
        if(!brandOptional.isPresent())
            throw new BrandNotFoundException("No Brand Found With id :"+ addProductDto.getBrandId());

        Brand brand= brandOptional.get();

        List<Category> categories= categoryRepository.findByIdIn(addProductDto.getCategoryIds());

        MetaData metaData= mapper.map(addProductDto,MetaData.class);
        metaData.setAddedOn(new java.util.Date());
        metaData.setUpdatedOn(new java.util.Date());

        Product product= new Product(addProductDto.getName(),metaData,brand,categories);

        try{
           product =productRepository.save(product);
        }catch(DataIntegrityViolationException ex){
            throw new ProductAlreadyExistException("Product with name "+addProductDto.getName()+" already exist");
        }

        return product;

    }

    @Override
    public Product updateProduct(ProductDto updateProductDto) {
        Optional<Product> productOptional= productRepository.findById(updateProductDto.getId());
        if(!productOptional.isPresent())
            throw new ProductNotFoundException("No Product Found With id :"+ updateProductDto.getBrandId());

        Optional<Brand> brandOptional= brandRepository.findById(updateProductDto.getBrandId());
        if(!brandOptional.isPresent())
            throw new BrandNotFoundException("No Brand Found With id :"+ updateProductDto.getBrandId());

        Brand brand= brandOptional.get();

        List<Category> categories= categoryRepository.findByIdIn(updateProductDto.getCategoryIds());

        MetaData metaData = new MetaData(updateProductDto.getDescription(), updateProductDto.getNotes(), new java.util.Date(), new java.util.Date());


        Product product= new Product(updateProductDto.getName(),metaData,brand,categories);
        product.setId(updateProductDto.getId());

        try{
            product =productRepository.save(product);
        }catch(DataIntegrityViolationException ex){
            throw new ProductAlreadyExistException("Product with name "+updateProductDto.getName()+" already exist");
        }

        return product;

    }

    @Override
    public String deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception ex) {
            throw new CategoryNotFoundException("No Product found with id " + id);
        }
        return new String("Product With Id: "+id+ " Deleted Successfully");
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    @Override
    public Product getProduct(long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (!productOptional.isPresent())
            throw new ProductNotFoundException("No Product found with id " + id);

        return productOptional.get();
    }

}
