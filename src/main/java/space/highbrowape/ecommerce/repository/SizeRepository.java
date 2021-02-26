package space.highbrowape.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import space.highbrowape.ecommerce.entity.Size;

public interface SizeRepository extends JpaRepository<Size,Long> {
}
