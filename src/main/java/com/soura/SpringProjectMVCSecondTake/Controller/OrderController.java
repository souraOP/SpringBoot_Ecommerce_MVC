package com.soura.SpringProjectMVCSecondTake.Controller;

import com.soura.SpringProjectMVCSecondTake.Model.dto.OrderRequest;
import com.soura.SpringProjectMVCSecondTake.Model.dto.OrderResponse;
import com.soura.SpringProjectMVCSecondTake.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrderController {
    // will do two things
    // 1. place order
    // 2. getAllOrders

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    // placing the order -> PostMapping
    @PostMapping("/orders/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse orderResponse = orderService.placeOrder(orderRequest);
        return new ResponseEntity<OrderResponse>(orderResponse, HttpStatus.CREATED);
    }


    // getting the orders -> GetMapping
    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getAllTheOrders(){
        List<OrderResponse> getResponse = orderService.getAllOrderResponses();
        try{
            return new ResponseEntity<List<OrderResponse>>(getResponse, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
