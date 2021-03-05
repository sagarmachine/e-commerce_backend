package space.highbrowape.ecommerce.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.ImgBBRes;
import space.highbrowape.ecommerce.entity.Image;
import space.highbrowape.ecommerce.exception.ImageNotSavedException;

import java.util.Base64;

@Service
public class ImageServiceImpl implements  IImageService {

    @Override
    public Image uploadImage(MultipartFile file){

        String url = "https://api.imgbb.com/1/upload?key=320af90c71366dd79d7cc0e77be63361";
        MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
        try {

            bodyMap.add("image",   Base64.getEncoder().encodeToString(file.getBytes()));

        } catch (Exception ex){
            throw new ImageNotSavedException("image was not saved try a different image");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ImgBBRes> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, ImgBBRes.class);

        ImgBBRes img= response.getBody();
        return new Image(img.getData().getThumb().getUrl(),img.getData().getDisplay_url(),img.getData().getDelete_url());

    }
}
