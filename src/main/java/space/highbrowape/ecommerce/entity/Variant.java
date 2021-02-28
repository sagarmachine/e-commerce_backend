package space.highbrowape.ecommerce.entity;

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
public class Variant extends Item implements  Serializable {

    @Column(nullable = false)
    private double costPrice;

    @Column(nullable = false)
    private double sellingPrice;


    @Embedded
    private Image image;

    @CollectionTable
    @ElementCollection
    @OrderColumn
    List<Image> images= new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Product product;



    @OneToMany(mappedBy ="variant",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<VariantSize> variantSizeSet= new HashSet<>();

}
