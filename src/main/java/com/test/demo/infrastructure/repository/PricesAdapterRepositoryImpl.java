package com.test.demo.infrastructure.repository;

import com.test.demo.domain.Price;
import com.test.demo.domain.adapter.repository.PricesAdapterRepository;
import com.test.demo.infrastructure.repository.converter.PricesAdapterRepositoryConverter;
import com.test.demo.infrastructure.repository.spring_data.PriceSpringDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PricesAdapterRepositoryImpl implements PricesAdapterRepository {

    private final PriceSpringDataRepository priceSpringDataRepository;
    private final PricesAdapterRepositoryConverter pricesAdapterRepositoryConverter;

    @Override
    public Optional<Price> getFinalPrice(Long brandId, Long productId, LocalDateTime date) {
        return priceSpringDataRepository.getFirstPriceByBrandIdAndProductIdAndDateIncludedAndPriorityMajor(brandId, productId, date)
                .map(pricesAdapterRepositoryConverter::toPrice);
    }
}
