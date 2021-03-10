package space.highbrowape.ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VariantImage{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

//    @Column(nullable = false)
    String thumbnail;

//    @Column(nullable = false)
    String main;

//    @Column(nullable = false)
    @JsonIgnore
    String deleteUrl;

    @OneToOne(mappedBy = "mainImage")
    Variant variantMain;

    @OneToOne(mappedBy = "thumbnailImage")
    Variant variantThumbnail;

    @ManyToOne
    @JoinColumn
    Variant variantAngle;

}
