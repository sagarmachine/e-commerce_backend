package space.highbrowape.ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@Setter
@Getter
//@Builder
public class Category extends Item{

    @ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY)
     @JsonIgnore
    Set<Product> products= new HashSet<>();

    public void addProduct(Product product)
    {products.add(product);
    }

    public Category(String name, Image image, MetaData metaData){
        super(name,image,metaData);
    }
    public  Category(long id,String name, Image image, MetaData metaData){
        super(id,name,image,metaData);
    }


}
