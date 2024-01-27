package com.razorpayment.controller;


import com.razorpay.*;
import com.razorpayment.payload.OrderRequest;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {
    //http://localhost:8080/api/create-order
    @PostMapping("/create-order")
    public String createOrder(@RequestBody OrderRequest order) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient("rzp_test_iaIsdyCE8p2BfK", "SmYMmnZsbrXHOwH0W1ozLNGX");

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", order.getAmount() * 100);
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "receipt#1");
        JSONObject notes = new JSONObject();
        notes.put("notes_key_1", "Tea, Earl Grey, Hot");
        notes.put("notes_key_1", "Tea, Earl Grey, Hot");
        orderRequest.put("notes", notes);

        Order orderResponse = razorpay.orders.create(orderRequest);
        String orderId = orderResponse.get("id").toString();

        return orderId;
    }


}
