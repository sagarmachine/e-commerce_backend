package space.highbrowape.ecommerce.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ProductDto {

    long id;

    @NotNull(message = "Category id can not be empty")
    long brandId;

    @NotNull(message = "Category id can not be empty")
    List<Long> categoryIds;

    @NotNull(message = "product name can't be empty")
    String name;

    String description;

    List<String> notes;

    public ProductDto(String name, String description, List<String> notes){
        this.name=name;
        this.description=description;
        this.notes=notes;
    }


}
