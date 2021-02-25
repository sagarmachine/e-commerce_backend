package space.highbrowape.ecommerce.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
public class Size extends Item implements  Serializable{

    @OneToMany(mappedBy ="size",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<VariantSize> variantSizes;
}