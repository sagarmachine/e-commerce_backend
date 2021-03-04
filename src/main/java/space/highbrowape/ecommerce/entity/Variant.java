package space.highbrowape.ecommerce.entity;

import lombok.*;
import org.hibernate.annotations.Formula;

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

     @OneToOne(mappedBy = "productMain", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     Product productMain;

//    @Formula("select")
    boolean complete=false;

    @Embedded
    private Image image;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "thumbnail", column = @Column(name = "thumbnail_thumbnail")),
            @AttributeOverride( name = "deleteUrl", column = @Column(name = "thumbnail_deleteUrl")),
            @AttributeOverride( name = "main", column = @Column(name = "thumbnail_main"))
    })
    private Image thumbnail;

    @CollectionTable
    @ElementCollection
    @OrderColumn
    List<Image> images= new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Product product;

    @OneToOne



    Integer threshold=null;

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


    @Enumerated(EnumType.STRING)
    Gender gender=Gender.N;//default



    @OneToMany(mappedBy ="variant",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<VariantSize> variantSizeSet= new HashSet<>();

}
