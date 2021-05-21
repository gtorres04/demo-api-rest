package com.test.demo.infrastructure.repository.spring_data;

import com.test.demo.infrastructure.repository.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceSpringDataRepository extends JpaRepository<PriceEntity, Long> {

    @Query(value = "SELECT * FROM prices p WHERE p.brand_id = ?1 AND p.product_id = ?2 AND p.start_date <= ?3 AND p.end_date >= ?3 ORDER BY p.priority ASC LIMIT 1", nativeQuery = true)
    Optional<PriceEntity> getFirstPriceByBrandIdAndProductIdAndDateIncludedAndPriorityMajor(Long brandId, Long productId, LocalDateTime date);
}
