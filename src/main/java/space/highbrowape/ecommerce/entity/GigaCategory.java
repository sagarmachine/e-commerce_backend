package space.highbrowape.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class GigaCategory extends Category implements  Serializable {





    @ManyToOne
    @JoinColumn
    @JsonIgnore
    TeraCategory teraCategory;


    @OneToMany(mappedBy ="gigaCategory",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<MegaCategory> categories= new HashSet<>();



    public GigaCategory(String name, Image image, MetaData metaData){
        super(name,image,metaData);
    }
    public GigaCategory(long id,String name, Image image, MetaData metaData){
        super(id,name,image,metaData);
    }

    public void addMegaCategory(MegaCategory megaCategory){
        if(categories==null){
            categories= new HashSet<MegaCategory>();
        }
        categories.add(megaCategory);
        megaCategory.setGigaCategory(this);
    }

}
