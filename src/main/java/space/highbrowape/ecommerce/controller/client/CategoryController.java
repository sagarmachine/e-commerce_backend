package space.highbrowape.ecommerce.controller.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.highbrowape.ecommerce.exception.NotFoundException;
import space.highbrowape.ecommerce.repository.*;

@RestController
@RequestMapping("/api/v1/client/category")
public class CategoryController {

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    BrandRepository brandRepository;


    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SizeRepository sizeRepository;

    @Autowired
    VariantRepository variantRepository;

    @GetMapping("/{id}/gender")
    ResponseEntity getDistinctGenders(@PathVariable long id){

        return ResponseEntity.ok(genderRepository.getGenders(categoryRepository.findById(id).get().getProducts()));
    }


    @GetMapping("/{id}/brands")
    ResponseEntity getDistinctBrand(@PathVariable long id){

        if(!categoryRepository.existsById(id))
             throw  new NotFoundException("category id "+id+" not found");
        return ResponseEntity.ok(brandRepository.getBrands(categoryRepository.findById(id).get().getProducts()));
    }

    @GetMapping("/{id}/sizes")
    ResponseEntity getDistinctSize(@PathVariable long id){

        if(!categoryRepository.existsById(id))
            throw  new NotFoundException("category id "+id+" not found");
        return ResponseEntity.ok(sizeRepository.findDistinctSize(categoryRepository.findById(id).get().getProducts()));
    }


    @GetMapping("/{id}/variants")
    ResponseEntity getDistinctVariants(@PathVariable long id){

        if(!categoryRepository.existsById(id))
            throw  new NotFoundException("category id "+id+" not found");
        return ResponseEntity.ok(variantRepository.findDistinctVariant(categoryRepository.findById(id).get().getProducts()));
    }

}
