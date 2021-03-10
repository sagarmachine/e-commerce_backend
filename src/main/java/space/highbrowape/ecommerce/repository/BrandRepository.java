package space.highbrowape.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import space.highbrowape.ecommerce.entity.Brand;
import space.highbrowape.ecommerce.entity.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface BrandRepository extends JpaRepository<Brand,Long> {

//
//    @Query(nativeQuery = true , value = "select * from brand where brand.id IN (select p.brand_id from product as p where p.id in (select cp.product_id from category_product  as cp inner join tera_category as c on c.id=cp.category_id where c.id=?1))")
//    HashSet<Brand> getBrands(long id);

       @Query(value = "from Brand b where b.id In (select p.brand.id from Product as p where p in :products)")
       HashSet<Object> getBrands(Set<Product> products);

}
