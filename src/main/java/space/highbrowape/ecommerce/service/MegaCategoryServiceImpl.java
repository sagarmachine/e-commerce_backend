package space.highbrowape.ecommerce.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.AddCategoryDto;
import space.highbrowape.ecommerce.dto.UpdateCategoryDto;
import space.highbrowape.ecommerce.entity.MegaCategory;
import space.highbrowape.ecommerce.entity.Image;
import space.highbrowape.ecommerce.entity.MetaData;
import space.highbrowape.ecommerce.entity.GigaCategory;
import space.highbrowape.ecommerce.exception.CategoryAlreadyExistException;
import space.highbrowape.ecommerce.exception.CategoryNotFoundException;
import space.highbrowape.ecommerce.repository.GigaCategoryRepository;
import space.highbrowape.ecommerce.repository.MegaCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MegaCategoryServiceImpl implements IMegaCategoryService{

    @Autowired
    MegaCategoryRepository megaCategoryRepository;

    @Autowired
    GigaCategoryRepository gigaCategoryRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public MegaCategory addCategory(long id, AddCategoryDto addCategoryDto, MultipartFile file) {

        Optional<GigaCategory> gigaCategoryOptional = gigaCategoryRepository.findById(id);

        if (!gigaCategoryOptional.isPresent())
            throw new CategoryNotFoundException("No GigaCategory found with id " + id);

        GigaCategory gigaCategory=gigaCategoryOptional.get();

        MetaData metaData = mapper.map(addCategoryDto, MetaData.class);
        metaData.setAddedOn(new java.util.Date());
        metaData.setUpdatedOn(new java.util.Date());

        Image image=new Image("abc","pqr","xyz");
        MegaCategory megaCategory = new MegaCategory(addCategoryDto.getName().toUpperCase(),image, metaData);
        gigaCategory.addMegaCategory(megaCategory);

        try {
            gigaCategoryRepository.save(gigaCategory);
        } catch (
                DataIntegrityViolationException ex) {
            throw new CategoryAlreadyExistException("MegaCategory with name " + addCategoryDto.getName().toUpperCase() + " already exist try a different name");
        }

        return (MegaCategory)megaCategoryRepository.findByName(addCategoryDto.getName().toUpperCase());
    }

    @Override
    public MegaCategory updateCategory(UpdateCategoryDto updateCategoryDto, MultipartFile file) {
        Optional<MegaCategory> megaCategoryOptional = megaCategoryRepository.findById(updateCategoryDto.getId());

        if (!megaCategoryOptional.isPresent())
            throw new CategoryNotFoundException("No MegaCategory found with id " + updateCategoryDto.getId());

        MegaCategory megaCategory=megaCategoryOptional.get();
        GigaCategory gigaCategory=megaCategory.getGigaCategory();
        gigaCategory.getMegaCategories().remove(megaCategory);

        MetaData metaData = mapper.map(updateCategoryDto, MetaData.class);
        metaData.setUpdatedOn(new java.util.Date());
        Image image=new Image("abc","pqr","xyz");
        megaCategory = new MegaCategory(updateCategoryDto.getId(),updateCategoryDto.getName().toUpperCase(), image, metaData);

        gigaCategory.addMegaCategory(megaCategory);

        try {
            gigaCategoryRepository.save(gigaCategory);
        } catch (DataIntegrityViolationException ex) {
            throw new CategoryAlreadyExistException("MegaCategory with name " + updateCategoryDto.getName().toUpperCase() + " already exist try a different name");
        }

        return (MegaCategory) megaCategoryRepository.findByName(updateCategoryDto.getName().toUpperCase());
    }

    @Override
    public String deleteCategory(long id) {


        try {
            megaCategoryRepository.deleteById(id);
        } catch (Exception ex) {
            throw new CategoryNotFoundException("No MegaCategory found with id " + id);
        }
        return new String("MegaCategory  Deleted Successfully");
    }

    @Override
    public List<MegaCategory> getAllCategories() {

        return megaCategoryRepository.findAll();
    }

    @Override
    public MegaCategory getCategory(long id) {

        Optional<MegaCategory> megaCategoryOptional = megaCategoryRepository.findById(id);

        if (!megaCategoryOptional.isPresent())
            throw new CategoryNotFoundException("No MegaCategory found with id " + id);

        return megaCategoryOptional.get();
    }


}
