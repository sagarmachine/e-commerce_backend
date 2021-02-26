package space.highbrowape.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.highbrowape.ecommerce.entity.MegaCategory;

public interface MegaCategoryRepository extends JpaRepository<MegaCategory,Long> {
}
