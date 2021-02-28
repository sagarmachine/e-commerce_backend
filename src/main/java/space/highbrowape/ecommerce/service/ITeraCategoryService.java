package space.highbrowape.ecommerce.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.AddCategoryDto;
import space.highbrowape.ecommerce.dto.UpdateCategoryDto;
import space.highbrowape.ecommerce.entity.TeraCategory;

import java.util.List;

public interface ITeraCategoryService {
    TeraCategory addCategory(AddCategoryDto addCategoryDto, MultipartFile file);

    TeraCategory updateCategory(UpdateCategoryDto updateCategoryDto, MultipartFile file);

    String  deleteCategory(long id);

    List<TeraCategory> getAllCategories();

    TeraCategory getCategory(long id);
}
