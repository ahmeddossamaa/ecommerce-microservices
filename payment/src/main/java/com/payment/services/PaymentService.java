package com.payment.services;

import com.payment.dto.PaymentRequestDto;
import com.payment.models.Payment;
import com.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public List<Payment> getPayments(){
        return this.paymentRepository.findAll();
    }

    public Payment pay(PaymentRequestDto paymentRequestDto){
        Payment payment = new Payment(
            paymentRequestDto.getOrderId(),
            paymentRequestDto.getPrice()
        );

        return this.paymentRepository.save(payment);
    }

    public void refund(Integer id){
        Payment payment = new Payment(id);

        this.paymentRepository.delete(payment);
    }
}
