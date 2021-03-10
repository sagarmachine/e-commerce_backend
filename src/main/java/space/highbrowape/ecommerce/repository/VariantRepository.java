package space.highbrowape.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import space.highbrowape.ecommerce.dto.response.VariantDto;
import space.highbrowape.ecommerce.entity.Variant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public interface VariantRepository extends JpaRepository<Variant,Long> {
    @Query(nativeQuery = true,value = "select distinct(v.name) as name,(select vi.thumbnail from variant_image as vi where vi.id=v.thumbnail_image_id) as image from variant as v where v.product_id in :products")
    HashSet<Object> findDistinctVariant(Set products);
}
