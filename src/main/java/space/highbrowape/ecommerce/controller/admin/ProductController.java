package space.highbrowape.ecommerce.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import space.highbrowape.ecommerce.dto.request.ProductDto;
import space.highbrowape.ecommerce.service.IBindingErrorService;
import space.highbrowape.ecommerce.service.IProductService;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/v1/admin/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @Autowired
    IBindingErrorService bindingErrorService;

    @PostMapping(value = "")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDto addProductDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            bindingErrorService.getErrorResponse(bindingResult);


        return new ResponseEntity<>(productService.addProduct(addProductDto), HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDto updateProductDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            bindingErrorService.getErrorResponse(bindingResult);


        return new ResponseEntity<>(productService.updateProduct(updateProductDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {

        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getAllProducts() {

        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProduct(@PathVariable long id) {

        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }
}
