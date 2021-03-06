package space.highbrowape.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Gender {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    long id;

    String value;

    @ManyToMany(mappedBy = "gender")
    Set<Variant> variant= new HashSet<>();


//    N,//none
//    U,//unisex
//    M,//men
//    W,//women
//    G,//girls
//    B,//boys
//    K;//kids

}
