package com.soura.SpringProjectMVCSecondTake.dto;

import java.util.List;

public record OrderRequest(
    String customerName,
    java.lang.String email,
    List<OrderItemRequest> items
) {}
