package space.highbrowape.ecommerce.exception;

import lombok.Getter;

@Getter
public class CategoryNotFoundException extends  RuntimeException{

    String message;

    public CategoryNotFoundException(String message){
        this.message=message;
    }


}
