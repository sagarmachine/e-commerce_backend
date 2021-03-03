package space.highbrowape.ecommerce.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.AddCategoryDto;
import space.highbrowape.ecommerce.dto.UpdateCategoryDto;
import space.highbrowape.ecommerce.dto.request.VariantDto;
import space.highbrowape.ecommerce.service.ITeraCategoryService;
import space.highbrowape.ecommerce.service.IVariantService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admin/variant")
public class VariantController {

    @Autowired
    IVariantService variantService;


    @PostMapping(value = "/body")
    public ResponseEntity<?> addVariantBody(@Valid @RequestBody VariantDto addVariantDto) {




        return new ResponseEntity<>(variantService.addVariantBody(addVariantDto), HttpStatus.ACCEPTED);

    }

    @PostMapping(value = "/{id}/images", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> addVariantImages(@PathVariable long id,@RequestBody MultipartFile[] files) {




        return new ResponseEntity<>(variantService.addVariantImages(id,files), HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "{id}/body")
    public ResponseEntity<?> updateVariantBody(@PathVariable long id,@Valid @RequestBody VariantDto addVariantDto) {


        return new ResponseEntity<>(variantService.updateVariantBody(addVariantDto), HttpStatus.ACCEPTED);

    }

    @PutMapping(value = "/{id}/images", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> updateVariantImages(@PathVariable long id,@RequestBody MultipartFile[] files) {




        return new ResponseEntity<>(variantService.updateVariantImages(id,files), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteVariant(@PathVariable Long id) {

        return new ResponseEntity<>(variantService.deleteVariant(id), HttpStatus.OK);
    }

    //Product id
    @GetMapping(value = "/product/{id}")
    public ResponseEntity<?> getAllProductVariants(@PathVariable Long id) {

        return new ResponseEntity<>(variantService.getAllProductVariants(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getVariant(@PathVariable long id) {

        return new ResponseEntity<>(variantService.getVariant(id), HttpStatus.OK);
    }



}

