package space.highbrowape.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import space.highbrowape.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
