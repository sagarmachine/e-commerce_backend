package space.highbrowape.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

//     @OneToOne(mappedBy = "mainVariant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//     Product productMain;

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
    @JsonIgnore
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

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "variant_gender", joinColumns = @JoinColumn(name = "variant_id"), inverseJoinColumns = @JoinColumn(name = "gender_id"))
    Set<Gender> genders=new HashSet<>();//default
//    public void addGender(Gender gender){
//        genders.add(gender);
//        gender.addVariant(this);
//    }

    @OneToMany(mappedBy ="variant",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    Set<VariantSize> variantSizeSet= new HashSet<>();

}
