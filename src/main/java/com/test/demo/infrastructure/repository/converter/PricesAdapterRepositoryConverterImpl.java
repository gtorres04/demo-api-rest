package com.test.demo.infrastructure.repository.converter;

import com.test.demo.domain.Price;
import com.test.demo.infrastructure.repository.entity.PriceEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PricesAdapterRepositoryConverterImpl implements PricesAdapterRepositoryConverter{
    public Price toPrice(PriceEntity priceEntity){
        var price = new Price();
        BeanUtils.copyProperties(priceEntity, price);
        price.setRateId(priceEntity.getPriceList());
        return price;
    }
}
