package com.payment.controllers;

import com.payment.dto.PaymentRequestDto;
import com.payment.models.Payment;
import com.payment.services.PaymentService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("")
    public ResponseEntity<List<Payment>> getAll(){
        List<Payment> payments = this.paymentService.getPayments();

        return ResponseEntity.ok().body(payments);
    }

    @PostMapping("")
    public ResponseEntity<Payment> create(@RequestBody PaymentRequestDto paymentRequestDto) {
        Payment payment = this.paymentService.pay(paymentRequestDto);

        return ResponseEntity.ok().body(payment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        this.paymentService.refund(id);

        return ResponseEntity.ok().body("Deleted Successfully!");
    }
}
