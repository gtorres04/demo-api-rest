package com.test.demo.domain.repository;

import com.test.demo.domain.Price;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public interface PricesAdapterRepository {
    Collection<Price> getFinalPrice(Long brandId, Long productId, LocalDateTime date);
}
