package space.highbrowape.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.request.BrandDto;
import space.highbrowape.ecommerce.entity.Brand;
import space.highbrowape.ecommerce.entity.Image;
import space.highbrowape.ecommerce.entity.MetaData;
import space.highbrowape.ecommerce.entity.TeraCategory;
import space.highbrowape.ecommerce.exception.BrandAlreadyExistException;
import space.highbrowape.ecommerce.exception.BrandNotFoundException;
import space.highbrowape.ecommerce.exception.CategoryAlreadyExistException;
import space.highbrowape.ecommerce.exception.CategoryNotFoundException;
import space.highbrowape.ecommerce.repository.BrandRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public Brand addBrand(BrandDto addBrandDto, MultipartFile file) {


        MetaData metaData = new MetaData(addBrandDto.getDescription(), addBrandDto.getNotes(), new java.util.Date(), new java.util.Date());

        //Image image=utilService.uploadImage(file);
        Image image = new Image("abc", "pqr", "xyz");
        Brand brand = new Brand(addBrandDto.getName(), image, metaData);

        try {
            brand = brandRepository.save(brand);
        } catch (DataIntegrityViolationException ex) {
            throw new BrandAlreadyExistException("Brand  with name " + addBrandDto.getName() + " already exist try a different name");
        }

        return brand;

    }

    @Override
    public Brand updateBrand(BrandDto updateBrandDto, MultipartFile file) {
        Optional<Brand> brandOptional= brandRepository.findById(updateBrandDto.getId());
        if(!brandOptional.isPresent())
            throw new BrandNotFoundException("No Brand Found With Id :"+ updateBrandDto.getId());

        MetaData metaData = new MetaData(updateBrandDto.getDescription(), updateBrandDto.getNotes(), new java.util.Date(), new java.util.Date());

        //Image image=utilService.uploadImage(file);
        Image image = new Image("abc", "pqr", "xyz");
        Brand brand = new Brand(updateBrandDto.getId(),updateBrandDto.getName(), image, metaData);

        try {
            brand = brandRepository.save(brand);
        } catch (DataIntegrityViolationException ex) {
            throw new BrandAlreadyExistException("Brand  with name " + updateBrandDto.getName() + " already exist try a different name");
        }

        return brand;
    }

    @Override
    public Brand getBrand(long id) {

        Optional<Brand> brandOptional= brandRepository.findById(id);
        if(!brandOptional.isPresent())
            throw new BrandNotFoundException("No Brand Found With Id :"+ id);

        return brandOptional.get();
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public String deleteBrand(Long id) {
        try {
            brandRepository.deleteById(id);
        } catch (Exception ex) {
            throw new BrandNotFoundException("No Brand found with id " + id);
        }
        return new String("Brand with id "+id+" Deleted Successfully");
    }
}
