package com.soura.SpringProjectMVCSecondTake.Model.dto;

public record OrderItemRequest(
        int productId,
        int quantity
) {}
