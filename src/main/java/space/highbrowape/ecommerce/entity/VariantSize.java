package space.highbrowape.ecommerce.entity;


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
    int stock;

    @JoinColumn
    @ManyToOne
    Variant variant;

    @JoinColumn
    @ManyToOne
    Size size;

}
