package space.highbrowape.ecommerce.exception;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends  RuntimeException{

    String message;

    public ProductNotFoundException(String message){
        this.message=message;
    }


}
