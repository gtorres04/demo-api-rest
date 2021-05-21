package com.test.demo.infrastructure.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity(name = "prices")
public class PriceEntity {

    @Id
    @Column(name = "price_list")
    private Long priceList;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "currency")
    private String currency;
}
