package space.highbrowape.ecommerce.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UpdateCategoryDto {

    long id;

    @NotNull(message = "category name can't be empty")
    String name;

    String description;

    List<String> notes;

    public UpdateCategoryDto(long id,String name, String description,List<String> notes){
        this.id=id;
        this.name=name;
        this.description=description;
        this.notes=notes;
    }

}
