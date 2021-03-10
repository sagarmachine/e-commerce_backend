package space.highbrowape.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Gender {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    long id;

    String value;

    @ManyToMany(mappedBy = "genders")
    @JsonIgnore
    Set<Variant> variants= new HashSet<>();

//    public void addVariant(Variant variant){
//        variants.add(variant);
//    }

//    N,//none
//    U,//unisex
//    M,//men
//    W,//women
//    G,//girls
//    B,//boys
//    K;//kids

}
