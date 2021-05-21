package com.test.demo.infrastructure.repository;

import com.test.demo.domain.Price;
import com.test.demo.domain.repository.PricesAdapterRepository;
import com.test.demo.infrastructure.repository.converter.PricesAdapterRepositoryConverter;
import com.test.demo.infrastructure.repository.spring_data.PriceSpringDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class PricesAdapterRepositoryImpl implements PricesAdapterRepository {

    private final PriceSpringDataRepository priceSpringDataRepository;
    private final PricesAdapterRepositoryConverter pricesAdapterRepositoryConverter;

    @Override
    public Collection<Price> getFinalPrice(Long brandId, Long productId, LocalDateTime date) {
        return priceSpringDataRepository.getPriceByBrandIdAndProductIdAndDateIncludedAndPriorityMajor(brandId, productId, date)
                .stream().map(pricesAdapterRepositoryConverter::toPrice).collect(Collectors.toList());
    }
}
