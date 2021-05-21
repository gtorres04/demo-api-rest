package com.test.demo.infrastructure.controller.converter;

import com.test.demo.domain.Price;
import com.test.demo.infrastructure.controller.api.model.PriceDto;
import org.springframework.stereotype.Component;

@Component
public class BrandApiConverterImpl implements BrandApiConverter {
    public PriceDto toPriceDto(Price price, String date){
        var priceResponse = new PriceDto();
        priceResponse.brandId(price.getBrandId().intValue());
        priceResponse.productId(price.getProductId().intValue());
        priceResponse.date(date);
        priceResponse.rateId(price.getRateId().intValue());
        priceResponse.price(price.getPrice());
        return priceResponse;
    }
}
