package space.highbrowape.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import space.highbrowape.ecommerce.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand,Long> {
}
