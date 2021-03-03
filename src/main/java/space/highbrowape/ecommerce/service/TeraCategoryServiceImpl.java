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
import space.highbrowape.ecommerce.entity.Image;
import space.highbrowape.ecommerce.entity.MetaData;
import space.highbrowape.ecommerce.entity.TeraCategory;
import space.highbrowape.ecommerce.exception.CategoryAlreadyExistException;
import space.highbrowape.ecommerce.exception.CategoryNotFoundException;
import space.highbrowape.ecommerce.repository.TeraCategoryRepository;

import java.util.List;
import java.util.Optional;


@Service
public class TeraCategoryServiceImpl implements ITeraCategoryService {

    @Autowired
    TeraCategoryRepository teraCategoryRepository;

    @Autowired
    IUtilService utilService;


    ModelMapper mapper = new ModelMapper();

    @Override
    public TeraCategory addCategory(AddCategoryDto addCategoryDto, MultipartFile file) {


        MetaData metaData = mapper.map(addCategoryDto, MetaData.class);
        metaData.setAddedOn(new java.util.Date());
        metaData.setUpdatedOn(new java.util.Date());

        //Image image=utilService.uploadImage(file);
        Image image=new Image("abc","pqr","xyz");
        TeraCategory teraCategory = new TeraCategory(addCategoryDto.getName().toUpperCase(),image, metaData);

        try {
            teraCategory = teraCategoryRepository.save(teraCategory);
        } catch (DataIntegrityViolationException ex) {
            throw new CategoryAlreadyExistException("TeraCategory  with name " + addCategoryDto.getName().toUpperCase() + " already exist try a different name");
        }

        return teraCategory;
    }

    @Override
    public TeraCategory updateCategory(UpdateCategoryDto updateCategoryDto, MultipartFile file) {
        Optional<TeraCategory> teraCategoryOptional = teraCategoryRepository.findById(updateCategoryDto.getId());

        if (!teraCategoryOptional.isPresent())
            throw new CategoryNotFoundException("No TeraCategory found with id " + updateCategoryDto.getId());

        MetaData metaData = mapper.map(updateCategoryDto, MetaData.class);
        metaData.setUpdatedOn(new java.util.Date());
        Image image=new Image("abc","pqr","xyz");
        TeraCategory teraCategory = new TeraCategory(updateCategoryDto.getId(),updateCategoryDto.getName().toUpperCase(), image, metaData);

        try {
            teraCategory = teraCategoryRepository.save(teraCategory);
        } catch (DataIntegrityViolationException ex) {
            throw new CategoryAlreadyExistException("TeraCategory  with name " + updateCategoryDto.getName().toUpperCase() + " already exist try a different name");
        }
        return teraCategory;
    }

    @Override
    public String deleteCategory(long id) {


        try {
            teraCategoryRepository.deleteById(id);
        } catch (Exception ex) {
            throw new CategoryNotFoundException("No TeraCategory found with id " + id);
        }
        return new String("TeraCategory Deleted Successfully");
    }

    @Override
    public List<TeraCategory> getAllCategories() {
        return teraCategoryRepository.findAll();
    }

    @Override
    public TeraCategory getCategory(long id) {
        Optional<TeraCategory> teraCategoryOptional = teraCategoryRepository.findById(id);

        if (!teraCategoryOptional.isPresent())
            throw new CategoryNotFoundException("No TeraCategory found with id " + id);

        return teraCategoryOptional.get();
    }


}
