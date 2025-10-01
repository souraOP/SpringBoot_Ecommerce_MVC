package com.soura.SpringProjectMVCSecondTake.dto;

public record OrderItemRequest(
        int productId,
        int quantity
) {}
