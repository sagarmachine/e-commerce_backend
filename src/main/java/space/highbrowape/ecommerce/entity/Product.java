
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
public class Product extends Item implements Serializable {

    @Column(nullable = false,unique = true)
    String name;


    boolean complete=false;

    @ManyToOne
    @JoinColumn
    Brand brand;

    @ManyToMany(mappedBy = "products")
    List<Category> categories;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Variant> variants;

    @OneToOne
    @JoinColumn
    Variant mainVariant;


    public Product(String name, MetaData metaData,Brand brand, List<Category> categories) {
        this.name=name;
        this.metadata=metaData;
        this.brand=brand;
        this.categories=categories;
    }

}
