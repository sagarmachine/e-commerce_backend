package space.highbrowape.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Brand extends Item implements  Serializable {


    @OneToMany(mappedBy ="brand",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<Product> products;


    public Brand(String name, Image image, MetaData metaData) {
        super(name,image,metaData);
    }

    public Brand(long id, String name, Image image, MetaData metaData) {
        super(id,name,image,metaData);
    }
}
