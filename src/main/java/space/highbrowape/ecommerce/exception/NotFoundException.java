package space.highbrowape.ecommerce.exception;

public class NotFoundException extends  RuntimeException{
    String message;

    public NotFoundException(String message){
        this.message=message;
    }

}
