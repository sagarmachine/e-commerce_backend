package space.highbrowape.ecommerce.exception;

import lombok.Getter;

@Getter
public class ImageNotSavedException extends  RuntimeException{

    String message;

    public ImageNotSavedException(String message){
        this.message=message;
    }


}
