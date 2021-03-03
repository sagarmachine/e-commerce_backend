package space.highbrowape.ecommerce.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class VariantDto {

    long id;

    @NotNull(message = "product Id can't be empty")
    long productId;

    @NotNull(message = "variant name can't be empty")
    String name;

    @NotNull(message = "costPrice can't be empty")
    double costPrice;

    @NotNull(message = "sellingPrice can't be empty")
    double sellingPrice;

    String description;

    List<String> notes;

    public VariantDto(String name, String description, List<String> notes){
        this.name=name;
        this.description=description;
        this.notes=notes;
    }

    List<MultipartFile> files;


}
