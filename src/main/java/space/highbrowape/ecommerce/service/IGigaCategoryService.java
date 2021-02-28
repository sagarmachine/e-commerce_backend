package space.highbrowape.ecommerce.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.AddCategoryDto;
import space.highbrowape.ecommerce.dto.UpdateCategoryDto;
import space.highbrowape.ecommerce.entity.GigaCategory;
import space.highbrowape.ecommerce.entity.TeraCategory;

import java.util.List;

public interface IGigaCategoryService {
    GigaCategory addCategory(long id, AddCategoryDto addCategoryDto, MultipartFile file);

    GigaCategory   updateCategory(UpdateCategoryDto updateCategoryDto, MultipartFile file);

    String  deleteCategory(long id);

    List<GigaCategory > getAllCategories();

    GigaCategory getCategory(long id);
}
