package space.highbrowape.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import space.highbrowape.ecommerce.entity.Variant;
import space.highbrowape.ecommerce.entity.VariantSize;

import java.util.HashSet;
import java.util.Set;


@Component
public interface VariantSizeRepository extends JpaRepository<VariantSize,Long> {



}
