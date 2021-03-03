package space.highbrowape.ecommerce.exception;

import lombok.Getter;

@Getter
public class BrandAlreadyExistException extends  RuntimeException{

    String message;

    public BrandAlreadyExistException(String message){
        this.message=message;
    }


}
