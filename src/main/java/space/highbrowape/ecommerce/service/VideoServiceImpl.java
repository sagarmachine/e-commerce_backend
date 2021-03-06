package space.highbrowape.ecommerce.service;

import com.pcloud.sdk.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.HashMap;

@Slf4j
@Service
public class VideoServiceImpl implements IVideoService {
    @Override
    public void uploadVideo(MultipartFile file) {

        Cloudinary cloudinary= new Cloudinary(new HashMap<String,String>(){{
            put("cloud_name", "sagarmonkey");
                put("api_key", "672729133477245");
                put("api_secret", "UrIdXypcYav8lX2GhSv_8_yOaaI");
        }});

        new HashMap<String, String>(){{
                    put( "resource_type", "image");
                    put("filename", "test");
                    put("directory", "samples");
        }};


        try {
          log.info(cloudinary.uploader().upload(new BASE64Encoder().encode(file.getBytes()),new HashMap()).toString());
        } catch (IOException e) {
           log.error("EXCEPTIOn "+e.getMessage());
        }


    }


//    void uploadViseoPCloud(MultipartFile file){
//        ApiClient apiClient = PCloudSdk.newClientBuilder()
//                .authenticator(Authenticators.newOAuthAuthenticator(<your OAuth access token here>))
//        // Other configuration...
//                .create();
//
//    }
}
