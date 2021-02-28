package space.highbrowape.ecommerce.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;


public interface IBindingErrorService {

    ResponseEntity<String[]> getErrorResponse(BindingResult bindingResult);


}
