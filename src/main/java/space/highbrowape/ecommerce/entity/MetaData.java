package space.highbrowape.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OrderBy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MetaData implements Serializable {



    String description;

    @CollectionTable
    @ElementCollection
    @OrderColumn
    List<String> notes;

    @CreationTimestamp
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date addedOn;

    @CreationTimestamp
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date updatedOn;




}
