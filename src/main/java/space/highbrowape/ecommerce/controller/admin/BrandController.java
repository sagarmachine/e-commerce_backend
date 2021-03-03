package space.highbrowape.ecommerce.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.AddCategoryDto;
import space.highbrowape.ecommerce.dto.UpdateCategoryDto;
import space.highbrowape.ecommerce.dto.request.BrandDto;
import space.highbrowape.ecommerce.dto.request.ProductDto;
import space.highbrowape.ecommerce.service.IBindingErrorService;
import space.highbrowape.ecommerce.service.IBrandService;
import space.highbrowape.ecommerce.service.IProductService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admin/brand")
public class BrandController {

    @Autowired
    IBrandService brandService;


    @PostMapping(value = "", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> addBrand(@RequestParam("name") String name,
                                      @RequestParam("description") String description,
                                      @RequestParam("note") String note,
                                      @RequestBody MultipartFile file) {


        List<String> notes = Arrays.asList(note.split(","));
        BrandDto addBrandDto = new BrandDto(name, description, notes);


        return new ResponseEntity<>(brandService.addBrand(addBrandDto, file), HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> updateBrand(@RequestParam("id") long id,
                                            @RequestParam("name") String name,
                                            @RequestParam("description") String description,
                                            @RequestParam("note") String note,
                                            @RequestBody MultipartFile file) {

        List<String> notes = Arrays.asList(note.split(","));
        BrandDto updateBrandDto = new BrandDto(name, description, notes);


        return new ResponseEntity<>(brandService.updateBrand(updateBrandDto, file), HttpStatus.ACCEPTED);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {

        return new ResponseEntity<>(brandService.deleteBrand(id), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getAllBrands() {

        return new ResponseEntity<>(brandService.getAllBrands(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getBrand(@PathVariable long id) {

        return new ResponseEntity<>(brandService.getBrand(id), HttpStatus.OK);
    }


}
