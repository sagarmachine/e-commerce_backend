package space.highbrowape.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
public class GigaCategory extends Item implements  Serializable {

    @ManyToOne
    @JoinColumn
    TeraCategory teraCategory;

    @OneToMany(mappedBy ="gigaCategory",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<MegaCategory> megaCategories;

}
