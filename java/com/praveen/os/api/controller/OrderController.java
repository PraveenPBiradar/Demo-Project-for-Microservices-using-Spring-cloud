package com.praveen.os.api.controller;

import com.praveen.os.api.common.Payment;
import com.praveen.os.api.common.TransactionRequest;
import com.praveen.os.api.common.TransactionResponse;
import com.praveen.os.api.model.Order;
import com.praveen.os.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public TransactionResponse saveOrder(@RequestBody TransactionRequest transactionRequest){
        return orderService.saveOrder(transactionRequest);
    }

    @PostMapping("/saveOnlyOrder")
    public String saveOnlyOrder(@RequestBody Order order){
        return orderService.saveOnlyOrder(order);
    }
}
