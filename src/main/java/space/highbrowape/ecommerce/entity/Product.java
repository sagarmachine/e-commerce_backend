
package space.highbrowape.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends Item implements Serializable {

//    @Column(nullable = false,unique = true)
//    String name;


    boolean complete=false;

    @ManyToOne
    @JoinColumn
    Brand brand;

    @ManyToMany()
    @JoinTable(name = "category_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonIgnore
    List<Category> categories= new ArrayList<>();
    public void addCategory(Category category)
    {
        categories.add(category);
        category.addProduct(this);
    }

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Variant> variants= new HashSet<>();

    public void addVariant(Variant variant){
        variants.add(variant);
        variant.setProduct(this);
    }

//    @OneToOne
//    @JoinColumn
//    Variant mainVariant;

    //for caching purpose----------------
    @CollectionTable
    @ElementCollection
    @OrderColumn
    List<String> extraChargeDetails;

    @CollectionTable
    @ElementCollection
    @OrderColumn
    List<String> deliveryDetails;

    @CollectionTable
    @ElementCollection
    @OrderColumn
    List<String> returnDetails;


    @CollectionTable
    @ElementCollection
    List<FAQ> faqs= new ArrayList<>();
    //---------------------------------


    public Product(String name, MetaData metaData,Brand brand, List<Category> categories) {
        this.name=name;
        this.metadata=metaData;
        this.brand=brand;
        this.categories=categories;
    }

}
