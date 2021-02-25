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
public class Product extends Item implements  Serializable {



    @ManyToOne
    @JoinColumn
    MegaCategory megaCategory;

    @ManyToOne
    @JoinColumn
    Brand brand;

    @OneToMany(mappedBy ="product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<Variant> variants;



}
