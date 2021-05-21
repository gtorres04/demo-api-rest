package com.test.demo.domain.adapter.repository;

import com.test.demo.domain.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PricesAdapterRepository {
    Optional<Price> getFinalPrice(Long brandId, Long productId, LocalDateTime date);
}
