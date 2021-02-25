package space.highbrowape.ecommerce.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Embeddable
public class Image implements Serializable {

    @Column(nullable = false)
    String thumbnail;

    @Column(nullable = false)
    String main;

    @Column(nullable = false)
    String delete;


}
