package space.highbrowape.ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

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
