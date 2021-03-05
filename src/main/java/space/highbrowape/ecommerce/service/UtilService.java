package space.highbrowape.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.ImgBBRes;
import space.highbrowape.ecommerce.entity.Image;
import space.highbrowape.ecommerce.exception.ImageNotSavedException;

import java.util.*;


@Service
public class UtilService  {

    @Autowired
    IImageService imageService;

    @Autowired
    IVideoService videoService;

    public Image uploadImage(MultipartFile file){
        return imageService.uploadImage(file);
    }
    public void uploadVideo(MultipartFile file){ videoService.uploadVideo(file);}

}
