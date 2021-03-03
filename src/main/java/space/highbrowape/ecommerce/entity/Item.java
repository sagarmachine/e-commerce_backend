package space.highbrowape.ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    long id;

    @NotNull(message = "Name cannot be blank")
    @Column(nullable = false,unique=true)
    String name;

    @Embedded
    Image image;

    @Embedded
    MetaData metadata;


    public Item(String name,  MetaData metadata){
        this.name=name;
        this.metadata=metadata;
    }

    public Item(String name, Image image, MetaData metadata){
        this.name=name;
        this.image=image;
        this.metadata=metadata;
    }





}
