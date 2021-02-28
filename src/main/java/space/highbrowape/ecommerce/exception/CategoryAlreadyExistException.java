package space.highbrowape.ecommerce.exception;

import lombok.Getter;

@Getter
public class CategoryAlreadyExistException extends  RuntimeException{

    String message;

    public CategoryAlreadyExistException(String message){
        this.message=message;
    }


}
