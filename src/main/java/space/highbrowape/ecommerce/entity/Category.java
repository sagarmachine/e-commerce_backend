package space.highbrowape.ecommerce.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@Setter
@Getter
//@Builder
public class Category extends Item{

   public Category(String name, Image image, MetaData metaData){
        super(name,image,metaData);
    }
    public  Category(long id,String name, Image image, MetaData metaData){
        super(id,name,image,metaData);
    }


}
