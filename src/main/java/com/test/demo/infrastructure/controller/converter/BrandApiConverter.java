package com.test.demo.infrastructure.controller.converter;

import com.test.demo.domain.Price;
import com.test.demo.infrastructure.controller.api.model.PriceDto;


public interface BrandApiConverter{
    PriceDto toPriceDto(Price price, String date);
}
