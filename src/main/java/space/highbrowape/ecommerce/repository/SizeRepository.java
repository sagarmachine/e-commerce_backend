package space.highbrowape.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import space.highbrowape.ecommerce.entity.Gender;
import space.highbrowape.ecommerce.entity.Product;
import space.highbrowape.ecommerce.entity.Size;

import java.util.HashSet;
import java.util.Set;

public interface SizeRepository extends JpaRepository<Size,Long> {

    HashSet<Size> findByIdIn(Set<Long> sizeIds);

    @Query(nativeQuery = true,value = "select * from size as s where s.id in (select distinct (vs.size_id) from variant_size as vs where  vs.variant_id in (select v.id from variant as v where v.product_id in :products))")
    HashSet<Object> findDistinctSize(Set<Product> products);


}
