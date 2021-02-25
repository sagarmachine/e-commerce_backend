package space.highbrowape.ecommerce.entity;

import lombok.*;
import org.hibernate.annotations.OrderBy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Metadata implements Serializable {


//    @Column
    String description;

    @CollectionTable
    @ElementCollection
    @OrderColumn
    List<String> notes;




}
