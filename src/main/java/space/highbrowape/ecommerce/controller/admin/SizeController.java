package space.highbrowape.ecommerce.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.highbrowape.ecommerce.service.ISizeService;

@RestController
@RequestMapping("/api/v1/admin/size")
public class SizeController {


    @Autowired
    ISizeService sizeService;

    @PostMapping("/{name}")
    public ResponseEntity<?> createSize(@PathVariable String name ){
        return ResponseEntity.ok(sizeService.createSize(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSize(@PathVariable long id){
        sizeService.deleteSize(id);
        return ResponseEntity.ok().build();

    }

}
