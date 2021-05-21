package com.test.demo.domain;

import com.test.demo.domain.exception.BrandIdInvalidException;
import com.test.demo.domain.exception.BrandIdIsNullException;
import com.test.demo.domain.exception.DateBadFormatException;
import com.test.demo.domain.exception.ProductIdInvalidException;
import com.test.demo.domain.exception.ProductIdIsNullException;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@Data
public class Price {

    private Long priceList;

    private Long brandId;

    private Long rateId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long productId;

    private Integer priority;

    private BigDecimal price;

    private String currency;

    public static void validProductId(Long productId) {
        if (isNull(productId)) throw new ProductIdIsNullException();
        if (isMinorThanZero(productId)) throw new ProductIdInvalidException();
    }

    public static void validBrandId(Long brandId) {
        if (isNull(brandId)) throw new BrandIdIsNullException();
        if (isMinorThanZero(brandId)) throw new BrandIdInvalidException();
    }

    private static boolean isMinorThanZero(Long id) {
        return id <= 0;
    }

    private static boolean isNull(Object id) {
        return null == id;
    }

    public static void validDate(String date) {
        if (!isFormat(date)) throw new DateBadFormatException();
    }

    private static boolean isFormat(String date) {
        try {
            LocalDateTime.parse(date);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
