package space.highbrowape.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import space.highbrowape.ecommerce.entity.Variant;

public interface VariantRepository extends JpaRepository<Variant,Long> {
}
