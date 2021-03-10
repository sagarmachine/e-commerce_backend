package space.highbrowape.ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VariantSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    long stock;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    Variant variant;

    @JoinColumn
    @ManyToOne
    Size size;

}
