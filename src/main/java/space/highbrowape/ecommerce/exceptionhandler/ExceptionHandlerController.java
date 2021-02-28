package space.highbrowape.ecommerce.exceptionhandler;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import space.highbrowape.ecommerce.exception.CategoryAlreadyExistException;
import space.highbrowape.ecommerce.exception.CategoryNotFoundException;
import space.highbrowape.ecommerce.exception.ImageNotSavedException;

@ControllerAdvice
public class ExceptionHandlerController {

       @ExceptionHandler(value = CategoryAlreadyExistException.class)
    public ResponseEntity<String[]> CategoryAlreadyExistExceptionHandler(CategoryAlreadyExistException ex){

        return    new ResponseEntity<>(new String[]{ex.getMessage()}, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = CategoryNotFoundException.class)
    public ResponseEntity<String[]> CategoryNotFoundExceptionHandler(CategoryNotFoundException ex){

        return    new ResponseEntity<>(new String[]{ex.getMessage()}, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(value = ImageNotSavedException.class)
    public ResponseEntity<String[]> ImageNotSavedExistExceptionHandler(ImageNotSavedException ex){

        return    new ResponseEntity<>(new String[]{ex.getMessage()}, HttpStatus.BAD_REQUEST);

    }


}
