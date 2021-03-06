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

     @OneToOne(mappedBy = "mainVariant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     Product productMain;

//    @Formula("select")
    boolean complete=false;

    @OneToOne
    @JoinColumn
    private VariantImage mainImage;


    @OneToOne
    @JoinColumn
    private VariantImage thumbnailImage;

    @OneToMany(mappedBy = "variantAngle", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<VariantImage> variantImages= new HashSet<>();

    @ManyToOne
    @JoinColumn
    Product product;

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


    @CollectionTable
    @ElementCollection
    List<FAQ> faqs= new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "variant_gender", joinColumns = @JoinColumn(name = "variant_id"), inverseJoinColumns = @JoinColumn(name = "gender_id"))
    Set<Gender> gender=new HashSet<>();//default


    @OneToMany(mappedBy ="variant",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<VariantSize> variantSizeSet= new HashSet<>();

}
