package space.highbrowape.ecommerce.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.request.VariantDto;
import space.highbrowape.ecommerce.entity.*;
import space.highbrowape.ecommerce.exception.NotFoundException;
import space.highbrowape.ecommerce.repository.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class VariantServiceImpl implements IVariantService {


    @Autowired
    VariantRepository variantRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    SizeRepository sizeRepository;

    @Autowired
    VariantSizeRepository variantSizeRepository;

    @Override
    public Variant addVariantBody(VariantDto addVariantDto) {



        if(!productRepository.existsById(addVariantDto.getProductId()))
              throw  new NotFoundException("product with id "+addVariantDto.getProductId()+" is not found");
        System.out.println("INSIDE");
        Product product= productRepository.findById(addVariantDto.getProductId()).get();
        Variant variant=  modelMapper.map(addVariantDto, Variant.class);
        System.out.println("INSIDE 2");
        MetaData metaData= MetaData.builder().description(addVariantDto.getDescription()).notes(addVariantDto.getNotes()).addedOn(new Date()).updatedOn(new Date()).build();
        variant.setMetadata(metaData);
        System.out.println("INSIDE 3");
       HashSet<Gender> genders= genderRepository.findByIdIn(addVariantDto.getGenders());
       HashSet<Size> sizes= sizeRepository.findByIdIn(addVariantDto.getSizes().keySet());
        variant.setGenders(genders);
        System.out.println("INSIDE 4");
        product.addVariant(variant);
        variantRepository.save(variant);
//        productRepository.save(product);
        for(Size size: sizes){
            VariantSize variantSize= VariantSize.builder().variant(variant).size(size).stock(addVariantDto.getSizes().get(size.getId())).build();
            variantSizeRepository.save(variantSize);
        }

          return variant;


    }

    @Override
    public Variant addVariantImages(long id, MultipartFile[] files) {
        return null;
    }

    @Override
    public Variant updateVariantBody(VariantDto addVariantDto) {
        return null;
    }

    @Override
    public Variant updateVariantImages(long id, MultipartFile[] files) {
        return null;
    }

    @Override
    public String deleteVariant(Long id) {
        return null;
    }

    @Override
    public List<Variant> getAllProductVariants(Long id) {
        return null;
    }

    @Override
    public Variant getVariant(long id) {
        return null;
    }
}
