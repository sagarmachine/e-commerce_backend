package space.highbrowape.ecommerce.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class BrandDto {

    long id;



    @NotNull(message = "product name can't be empty")
    String name;

    String description;

    List<String> notes;

    public BrandDto(String name, String description, List<String> notes){
        this.name=name;
        this.description=description;
        this.notes=notes;
    }


}
