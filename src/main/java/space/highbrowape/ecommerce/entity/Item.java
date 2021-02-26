package space.highbrowape.ecommerce.entity;


import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String name;

    @Embedded
    Image image;

    @Embedded
    MetaData metadata;




}
