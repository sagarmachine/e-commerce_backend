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
public class TeraCategory extends Category implements  Serializable {




    @OneToMany(mappedBy ="teraCategory",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<GigaCategory> categories= new HashSet<>();



    public TeraCategory(String name, Image image, MetaData metaData){
        super(name,image,metaData);
    }
    public TeraCategory(long id,String name, Image image, MetaData metaData){
        super(id,name,image,metaData);
    }

    public void addGigaCategory(GigaCategory gigaCategory){
        if(categories==null){
            categories= new HashSet<GigaCategory>();
        }
        categories.add(gigaCategory);
        gigaCategory.setTeraCategory(this);
    }

}
