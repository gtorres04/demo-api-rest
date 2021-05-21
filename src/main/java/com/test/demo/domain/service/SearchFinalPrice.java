package com.test.demo.domain.service;

import com.test.demo.domain.Price;
import com.test.demo.domain.annotation.DomainService;
import com.test.demo.domain.repository.PricesAdapterRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

@DomainService
@AllArgsConstructor
public class SearchFinalPrice {
    private final PricesAdapterRepository pricesAdapterRepository;

    public Optional<Price> execute(final Long brandId, final Long productId, final String date) {
        Price.validBrandId(brandId);
        Price.validProductId(brandId);
        Price.validDate(date);
        var dateToCompare = date != null ? getLocalDateTime(date) : getNow();
        return pricesAdapterRepository.getFinalPrice(brandId, productId, dateToCompare).stream().min(Comparator.comparing(Price::getPriority));
    }

    protected LocalDateTime getNow() {
        return LocalDateTime.now();
    }

    private LocalDateTime getLocalDateTime(String date) {
        return LocalDateTime.parse(date);
    }
}
