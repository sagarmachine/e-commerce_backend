package space.highbrowape.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Image implements Serializable {

    @Column(nullable = false)
    String thumbnail;

    @Column(nullable = false)
    String main;

    @Column(nullable = false)
    @JsonIgnore
    String deleteUrl;


}
