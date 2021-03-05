package space.highbrowape.ecommerce.service;


import org.springframework.web.multipart.MultipartFile;

public interface IVideoService {

    void uploadVideo(MultipartFile file);
}
