package space.highbrowape.ecommerce.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.AddCategoryDto;
import space.highbrowape.ecommerce.dto.UpdateCategoryDto;
import space.highbrowape.ecommerce.service.IGigaCategoryService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admin/gigaCategory")
public class GigaCategoryController {


    @Autowired
    IGigaCategoryService gigaCategoryService;

    // TeraCategory Id
    @PostMapping(value="/{id}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> addCategory(
            @PathVariable long id,
            @RequestParam("name")String name,
            @RequestParam("description")String description,
            @RequestParam("note") String note,
            @RequestBody MultipartFile file){


        List<String > notes= Arrays.asList(note.split(","));
        AddCategoryDto addCategoryDto= new AddCategoryDto(name,description,notes);


        return new ResponseEntity<>( gigaCategoryService.addCategory(id,addCategoryDto,file), HttpStatus.ACCEPTED);

    }

    @PutMapping(value="",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> updateCategory( @RequestParam("id") long id,
                                             @RequestParam("name")String name,
                                             @RequestParam("description")String description,
                                             @RequestParam("note") String note,
                                             @RequestBody MultipartFile file){


        List<String > notes= Arrays.asList(note.split(","));
        UpdateCategoryDto updateCategoryDto= new UpdateCategoryDto(id,name,description,notes);


        return new ResponseEntity<>( gigaCategoryService.updateCategory(updateCategoryDto,file), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){

        return new ResponseEntity<>(gigaCategoryService.deleteCategory(id),HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getAllCategories() {

        return new ResponseEntity<>(gigaCategoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCategory(@PathVariable long id) {

        return new ResponseEntity<>(gigaCategoryService.getCategory(id), HttpStatus.OK);
    }

}
