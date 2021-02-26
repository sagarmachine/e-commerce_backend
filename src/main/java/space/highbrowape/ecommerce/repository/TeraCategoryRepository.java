package space.highbrowape.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.highbrowape.ecommerce.entity.TeraCategory;

public interface TeraCategoryRepository extends JpaRepository<TeraCategory,Long> {
}
