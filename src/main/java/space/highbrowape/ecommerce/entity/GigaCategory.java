package space.highbrowape.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GigaCategory extends Item implements  Serializable {





    @ManyToOne
    @JoinColumn
    TeraCategory teraCategory;

    @OneToMany(mappedBy ="gigaCategory",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<MegaCategory> megaCategories;

    public GigaCategory(String name, Image image, MetaData metaData){
        super(name,image,metaData);
    }
    public GigaCategory(long id,String name, Image image, MetaData metaData){
        super(id,name,image,metaData);
    }

    public void addMegaCategory(MegaCategory megaCategory){
        if(megaCategories==null){
            megaCategories= new HashSet<MegaCategory>();
        }
        megaCategories.add(megaCategory);
        megaCategory.setGigaCategory(this);
    }

}
