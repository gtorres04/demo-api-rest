package com.test.demo.infrastructure.controller;

import com.test.demo.domain.service.SearchFinalPrice;
import com.test.demo.infrastructure.controller.api.model.PriceDto;
import com.test.demo.infrastructure.controller.converter.BrandApiConverter;
import com.test.demo.infrastructure.controller.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.test.demo.infrastructure.controller.api.BrandsApi;

@RestController
@AllArgsConstructor
public class BrandsApiImpl implements BrandsApi {

    private final SearchFinalPrice searchFinalPrice;
    private final BrandApiConverter brandApiConverter;

    @Override
    public ResponseEntity<PriceDto> getPrice(Integer brandId, Integer productId, String date) {
        var price = searchFinalPrice.execute(Long.valueOf(brandId), Long.valueOf(productId), date).orElseThrow(ResourceNotFoundException::new);
        return ResponseEntity.ok(brandApiConverter.toPriceDto(price, date));
    }
}
