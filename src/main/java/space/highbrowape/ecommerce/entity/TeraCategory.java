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
public class TeraCategory extends Item implements  Serializable {



    @OneToMany(mappedBy ="teraCategory",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<GigaCategory> gigaCategories;


}
