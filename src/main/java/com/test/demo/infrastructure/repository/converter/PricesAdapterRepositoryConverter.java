package com.test.demo.infrastructure.repository.converter;

import com.test.demo.domain.Price;
import com.test.demo.infrastructure.repository.entity.PriceEntity;

public interface PricesAdapterRepositoryConverter {
    public Price toPrice(PriceEntity priceEntity);
}
