package com.praveen.ps.api.controller;

import com.praveen.ps.api.model.Payment;
import com.praveen.ps.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/savePayment")
    public Payment savePayment(@RequestBody Payment payment){
        return  paymentService.savePayment(payment);
    }
}
