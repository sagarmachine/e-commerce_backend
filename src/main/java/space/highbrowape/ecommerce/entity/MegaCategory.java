package space.highbrowape.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MegaCategory extends Category implements  Serializable {

    @ManyToOne
    @JoinColumn
    GigaCategory gigaCategory;

    @OneToMany(mappedBy ="category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<Product> products= new HashSet<>();

    public MegaCategory(String name, Image image, MetaData metaData){
        super(name,image,metaData);
    }
    public MegaCategory(long id,String name, Image image, MetaData metaData){
        super(id,name,image,metaData);
    }
}
