package com.praveen.os.api.service;

import com.praveen.os.api.common.Payment;
import com.praveen.os.api.common.TransactionRequest;
import com.praveen.os.api.common.TransactionResponse;
import com.praveen.os.api.model.Order;
import com.praveen.os.api.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest transactionRequest){
        String message="";
        Order order=transactionRequest.getOrder();
        Payment payment=transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call to payment api
        orderRepository.save(order);
        Payment paymentResponse=restTemplate.postForObject("http://PAYMENT-SERVICE/payment/savePayment",payment,Payment.class);
        message=paymentResponse.getPaymentStatus().equals("success")?"payment successfull and order placed":" payment failed .. order added to cart";
        return new TransactionResponse(order,paymentResponse.getTransactionId(),paymentResponse.getAmount(),message);
    }

    public String saveOnlyOrder(Order order){
        String message="";
        Payment payment=new Payment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        Payment paymentResponse=restTemplate.postForObject("http://localhost:9192/payment/savePayment",payment,Payment.class);
        message=paymentResponse.getPaymentStatus().equals("success")?"payment successfull and order placed":" payment failed .. order added to cart";
        return message;
    }
}