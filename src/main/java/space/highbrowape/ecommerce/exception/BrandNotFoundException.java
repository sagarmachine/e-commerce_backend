package space.highbrowape.ecommerce.exception;

import lombok.Getter;

@Getter
public class BrandNotFoundException extends  RuntimeException{

    String message;

    public BrandNotFoundException(String message){
        this.message=message;
    }


}
