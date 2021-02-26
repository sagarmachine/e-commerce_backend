package space.highbrowape.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import space.highbrowape.ecommerce.entity.VariantSize;


@Component
public interface VariantSizeRepository extends JpaRepository<VariantSize,Long> {
}
