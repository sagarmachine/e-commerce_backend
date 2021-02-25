package space.highbrowape.ecommerce.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
public class VariantSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    int stock;

    @JoinColumn
    @ManyToOne
    Variant variant;

    @JoinColumn
    @ManyToOne
    Size size;

}
