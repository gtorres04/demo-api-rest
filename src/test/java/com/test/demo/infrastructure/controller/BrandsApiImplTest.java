package com.test.demo.infrastructure.controller;

import com.test.demo.ApplicationRestTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BrandsApiImplTest extends ApplicationRestTest {

    @ParameterizedTest
    @CsvSource({
            "1,35455,2020-06-14T10:00:00",
            "1,35455,2020-06-14T16:00:00",
            "1,35455,2020-06-14T21:00:00",
            "1,35455,2020-06-15T15:00:00",
            "1,35455,2020-06-16T16:00:00"
    })
    void get(Long brandId, Long productId, String date) throws Exception {
        assertResponse("GET",
                String.format("/brands/%s/products/%s/price?date=%s", brandId, productId, date),
                200,
                "{\"price\":35.50,\"brand_id\":1,\"product_id\":35455,\"rate_id\":1,\"date\":\""+date+"\"}");
    }

    @ParameterizedTest
    @CsvSource({
            "100,35455,2020-06-14T10:00:00",
            "1,456987,2020-06-14T16:00:00"
    })
    void getResourceNotFound(String brandId, String productId, String date) throws Exception {
        assertResponse("GET",
                String.format("/brands/%s/products/%s/price?date=%s", brandId, productId, date),
                404,
                "{\"message\":\"Recurso no encontrado\",\"request_id\":null,\"details\":null,\"code\":\"ResourceNotFoundException\"}");
    }

    @ParameterizedTest
    @CsvSource({
            "1,35455,ABCD-AB-14T16:CV:00"
    })
    void getBadRequest(String brandId, String productId, String date) throws Exception {
        assertResponse("GET",
                String.format("/brands/%s/products/%s/price?date=%s", brandId, productId, date),
                400,
                "{\"message\":\"Formato de la fecha invalido\",\"request_id\":null,\"details\":null,\"code\":\"DateBadFormatException\"}");
    }
}
