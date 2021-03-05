package space.highbrowape.ecommerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.service.UtilService;

@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    UtilService utilService;

    @RequestMapping("/upload")
     public String test (@RequestBody MultipartFile file)
    {
        utilService.uploadVideo(file);

        return "test";

    }

}
