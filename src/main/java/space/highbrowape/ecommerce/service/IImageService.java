package space.highbrowape.ecommerce.service;

import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.entity.Image;

public interface IImageService {
    Image uploadImage (MultipartFile file);
}
