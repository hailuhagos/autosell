package com.autosell.serviceImpl;


import com.autosell.domains.Payment;
import com.autosell.repositories.PaymentRepository;
import com.autosell.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaymentImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Transactional
    public Payment save(Payment payment){
        return paymentRepository.save(payment);
    }
    @Transactional
    public List<Payment> getAllPayment(){
        return paymentRepository.findAll();
    }

    @Transactional
    public Payment findById(long id) {
        return paymentRepository.findById(id);
    }
    @Transactional
    public void delete(Payment Payment) {
        paymentRepository.delete(Payment);
    }
}
