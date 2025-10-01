package com.soura.SpringProjectMVCSecondTake.Service;

import com.soura.SpringProjectMVCSecondTake.Model.Order;
import com.soura.SpringProjectMVCSecondTake.Model.OrderItem;
import com.soura.SpringProjectMVCSecondTake.Model.Product;
import com.soura.SpringProjectMVCSecondTake.Model.dto.OrderItemRequest;
import com.soura.SpringProjectMVCSecondTake.Model.dto.OrderItemResponse;
import com.soura.SpringProjectMVCSecondTake.Model.dto.OrderRequest;
import com.soura.SpringProjectMVCSecondTake.Model.dto.OrderResponse;
import com.soura.SpringProjectMVCSecondTake.Repo.OrderRepo;
import com.soura.SpringProjectMVCSecondTake.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Service
public class OrderService {
    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    @Autowired
    public OrderService(ProductRepo productRepo, OrderRepo orderRepo){
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        String orderUUID = java.util.UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        order.setOrderId(orderUUID);
        order.setCustomerName(orderRequest.customerName());
        order.setEmail(orderRequest.email());
        order.setStatus("Order Placed!!!");
        order.setOrderDate(LocalDate.now());

        List<OrderItem> orderItems = new ArrayList<>();
        for(OrderItemRequest oir: orderRequest.items()){
            Product product = productRepo.findById(oir.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            product.setStockQuantity(product.getStockQuantity() - oir.quantity());
            productRepo.save(product);

            OrderItem orderItem = OrderItem.builder()
                    .product(product)
                    .quantity(oir.quantity())
                    .totalPrice(product.getPrice().multiply(BigDecimal.valueOf(oir.quantity())))
                    .build();

            orderItems.add(orderItem);

        }

        order.setOrderItems(orderItems);
        Order savedOrder=orderRepo.save(order);

        List<OrderItemResponse> itemResponses = new ArrayList<>();
        for(OrderItem item: order.getOrderItems()){
            OrderItemResponse orderItemResponse = new OrderItemResponse(
                    item.getProduct().getProductName(),
                    item.getQuantity(),
                    item.getTotalPrice()
            );
            itemResponses.add(orderItemResponse);
        }

        OrderResponse orderResponse = new OrderResponse(
                savedOrder.getOrderId(),
                savedOrder.getCustomerName(),
                savedOrder.getEmail(),
                savedOrder.getStatus(),
                savedOrder.getOrderDate(),
                itemResponses
        );

        return orderResponse;
    }

    public List<OrderResponse> getAllOrderResponses(){
        return null;
    }
}
