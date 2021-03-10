package space.highbrowape.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import space.highbrowape.ecommerce.entity.Category;
import space.highbrowape.ecommerce.entity.Gender;
import space.highbrowape.ecommerce.entity.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface GenderRepository extends JpaRepository<Gender, Long> {


//    @Query( nativeQuery = true,
//            value = "select * from gender where gender.id IN (select distinct (vg.gender_id) from variant_gender as vg inner join variant as v on v.id=vg.variant_id where v.id in (select v2.id from product as p inner join variant as v2 on v2.product_id=p.id where p.id in (select cp.product_id from category_product  as cp inner join tera_category as c on c.id=cp.category_id where c.id=?1)))")
//    List<Gender> getGenders(long id);

    @Query( nativeQuery = true,
            value = "select * from gender where gender.id IN (select distinct (vg.gender_id) from variant_gender as vg inner join variant as v on v.id=vg.variant_id where v.id in (select v2.id from product as p inner join variant as v2 on v2.product_id=p.id where p.id in :products))")
    List<Gender> getGenders(Set<Product> products);


    HashSet<Gender> findByIdIn(HashSet<Long> genderIds);


}
