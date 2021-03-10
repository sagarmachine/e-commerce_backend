package space.highbrowape.ecommerce.exceptionhandler;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import space.highbrowape.ecommerce.exception.*;

@ControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<String[]> NotFoundException(NotFoundException ex){

        return    new ResponseEntity<>(new String[]{ex.getMessage()}, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = AlreadyExistException.class)
    public ResponseEntity<String[]> AlreadyExistException(AlreadyExistException ex){

        return    new ResponseEntity<>(new String[]{ex.getMessage()}, HttpStatus.BAD_REQUEST);

    }

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

    @ExceptionHandler(value = BrandAlreadyExistException.class)
    public ResponseEntity<String[]> BrandAlreadyExistExceptionHandler(BrandAlreadyExistException ex){

        return    new ResponseEntity<>(new String[]{ex.getMessage()}, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(value = BrandNotFoundException.class)
    public ResponseEntity<String[]> BrandNotFoundExceptionHandler(BrandNotFoundException ex){

        return    new ResponseEntity<>(new String[]{ex.getMessage()}, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = ProductAlreadyExistException.class)
    public ResponseEntity<String[]> ProductAlreadyExistExceptionHandler(ProductAlreadyExistException ex){

        return    new ResponseEntity<>(new String[]{ex.getMessage()}, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<String[]> ProductNotFoundExceptionHandler(ProductNotFoundException ex){

        return    new ResponseEntity<>(new String[]{ex.getMessage()}, HttpStatus.BAD_REQUEST);

    }


}
