package com.smartorder.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class OrderValidationFunction {

    @Bean
    public Function<OrderRequest, String> validateOrder() {
        return request -> {
            if (request.getProductId() == null || request.getProductId().isBlank()) {
                return "Invalid Order: Product ID is missing.";
            }

            if (request.getQuantity() <= 0) {
                return "Invalid Order: Quantity must be greater than zero.";
            }

            return "Order is valid.";
        };
    }
}
