package space.highbrowape.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Variant extends Item implements  Serializable {


    @ManyToOne
    @JoinColumn
    Product product;

    @CollectionTable
    @ElementCollection
    @OrderColumn
    List<Image> images;

    @OneToMany(mappedBy ="variant",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<VariantSize> variantSizes;

}
