package space.highbrowape.ecommerce.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.AddCategoryDto;
import space.highbrowape.ecommerce.dto.UpdateCategoryDto;
import space.highbrowape.ecommerce.entity.GigaCategory;
import space.highbrowape.ecommerce.entity.Image;
import space.highbrowape.ecommerce.entity.MetaData;
import space.highbrowape.ecommerce.entity.TeraCategory;
import space.highbrowape.ecommerce.exception.CategoryAlreadyExistException;
import space.highbrowape.ecommerce.exception.CategoryNotFoundException;
import space.highbrowape.ecommerce.repository.GigaCategoryRepository;
import space.highbrowape.ecommerce.repository.TeraCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GigaCategoryServiceImpl implements IGigaCategoryService {


    @Autowired
    GigaCategoryRepository gigaCategoryRepository;

    @Autowired
    TeraCategoryRepository teraCategoryRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public GigaCategory addCategory(long id, AddCategoryDto addCategoryDto, MultipartFile file) {

        Optional<TeraCategory> teraCategoryOptional = teraCategoryRepository.findById(id);

        if (!teraCategoryOptional.isPresent())
            throw new CategoryNotFoundException("No TeraCategory found with id " + id);

        TeraCategory teraCategory=teraCategoryOptional.get();

        MetaData metaData = mapper.map(addCategoryDto, MetaData.class);
        metaData.setAddedOn(new java.util.Date());
        metaData.setUpdatedOn(new java.util.Date());

    Image image=new Image("abc","pqr","xyz");
    GigaCategory gigaCategory = new GigaCategory(addCategoryDto.getName().toUpperCase(),image, metaData);
    teraCategory.addGigaCategory(gigaCategory);

        try {
        teraCategoryRepository.save(teraCategory);
    } catch (
    DataIntegrityViolationException ex) {
        throw new CategoryAlreadyExistException("gigaCategory with name " + addCategoryDto.getName().toUpperCase() + " already exist try a different name");
    }

        return (GigaCategory)gigaCategoryRepository.findByName(addCategoryDto.getName().toUpperCase());
}

    @Override
    public GigaCategory updateCategory(UpdateCategoryDto updateCategoryDto, MultipartFile file) {
        Optional<GigaCategory> gigaCategoryOptional = gigaCategoryRepository.findById(updateCategoryDto.getId());

        if (!gigaCategoryOptional.isPresent())
            throw new CategoryNotFoundException("No gigaCategory found with id " + updateCategoryDto.getId());

        GigaCategory gigaCategory=gigaCategoryOptional.get();
        TeraCategory teraCategory=gigaCategory.getTeraCategory();
        teraCategory.getCategories().remove(gigaCategory);

        MetaData metaData = mapper.map(updateCategoryDto, MetaData.class);
        metaData.setUpdatedOn(new java.util.Date());
        Image image=new Image("abc","pqr","xyz");
        gigaCategory = new GigaCategory(updateCategoryDto.getId(),updateCategoryDto.getName().toUpperCase(), image, metaData);

        teraCategory.addGigaCategory(gigaCategory);

        try {
           teraCategoryRepository.save(teraCategory);
        } catch (DataIntegrityViolationException ex) {
            throw new CategoryAlreadyExistException("gigaCategory with name " + updateCategoryDto.getName().toUpperCase() + " already exist try a different name");
        }

        return (GigaCategory) gigaCategoryRepository.findByName(updateCategoryDto.getName().toUpperCase());
    }

    @Override
    public String deleteCategory(long id) {


        try {
            gigaCategoryRepository.deleteById(id);
        } catch (Exception ex) {
            throw new CategoryNotFoundException("No gigaCategory found with id " + id);
        }
        return new String("gigaCategory Deleted Successfully");
    }

    @Override
    public List<GigaCategory> getAllCategories() {

        return gigaCategoryRepository.findAll();
    }

    @Override
    public GigaCategory getCategory(long id) {

        Optional<GigaCategory> gigaCategoryOptional = gigaCategoryRepository.findById(id);

        if (!gigaCategoryOptional.isPresent())
            throw new CategoryNotFoundException("No gigaCategory found with id " + id);

        return gigaCategoryOptional.get();
    }


}
