package space.highbrowape.ecommerce.exception;

public class AlreadyExistException extends  RuntimeException{
    String message;

    public AlreadyExistException(String message){
        this.message=message;
    }

}
