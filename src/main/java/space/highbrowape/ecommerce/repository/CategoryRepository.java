package space.highbrowape.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.highbrowape.ecommerce.entity.Category;
import space.highbrowape.ecommerce.entity.TeraCategory;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);

    List<Category> findByIdIn(List<Long> categoryIds);
}
