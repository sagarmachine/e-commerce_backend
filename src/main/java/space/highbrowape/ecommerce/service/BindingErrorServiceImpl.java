package space.highbrowape.ecommerce.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Service
public class BindingErrorServiceImpl implements IBindingErrorService{
    @Override
    public ResponseEntity<String[]> getErrorResponse(BindingResult bindingResult) {



         List<ObjectError> errorList= bindingResult.getAllErrors();
        String [] errorArray= new String[errorList.size()];
         int c=0;
         for (ObjectError error:errorList){
           errorArray[c++]= error.getDefaultMessage();
         }

        return new ResponseEntity<>(errorArray, HttpStatus.BAD_REQUEST);

    }
}
