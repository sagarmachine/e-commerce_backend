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
public class MegaCategory extends Item implements  Serializable {



    @ManyToOne
    @JoinColumn
    GigaCategory gigaCategory;

    @OneToMany(mappedBy ="megaCategory",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<Product> products;
}
