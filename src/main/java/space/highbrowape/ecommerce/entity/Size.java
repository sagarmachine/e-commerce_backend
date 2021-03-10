package space.highbrowape.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Size  implements  Serializable{


    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false, unique = true)
    String value;

    @OneToMany(mappedBy ="size",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    Set<VariantSize> variantSizes;
}
