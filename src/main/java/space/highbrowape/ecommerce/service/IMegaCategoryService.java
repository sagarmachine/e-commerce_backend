package space.highbrowape.ecommerce.service;

import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.AddCategoryDto;
import space.highbrowape.ecommerce.dto.UpdateCategoryDto;
import space.highbrowape.ecommerce.entity.GigaCategory;
import space.highbrowape.ecommerce.entity.MegaCategory;

import java.util.List;

public interface IMegaCategoryService {

    MegaCategory addCategory(long id, AddCategoryDto addCategoryDto, MultipartFile file);

    MegaCategory   updateCategory(UpdateCategoryDto updateCategoryDto, MultipartFile file);

    String  deleteCategory(long id);

    List<MegaCategory> getAllCategories();

    MegaCategory getCategory(long id);
}
