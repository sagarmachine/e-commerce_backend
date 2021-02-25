package space.highbrowape.ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String name;

    @Column
    @Embedded
    Image image;

    @Column
    @Embedded
    Metadata metadata;

    @CreationTimestamp
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date addedOn;


}
