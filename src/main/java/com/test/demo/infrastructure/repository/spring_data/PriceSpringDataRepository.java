package com.test.demo.infrastructure.repository.spring_data;

import com.test.demo.domain.Price;
import com.test.demo.infrastructure.repository.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Collection;

public interface PriceSpringDataRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM prices p WHERE p.brandId = ?1 and p.productId = ?2 and p.startDate <= ?3 and p.endDate >= ?3")
    Collection<PriceEntity> getPriceByBrandIdAndProductIdAndDateIncludedAndPriorityMajor(Long brandId, Long productId, LocalDateTime date);
}
