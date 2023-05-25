package com.backend.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entity.Voucher;
import com.backend.repository.VoucherRepository;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;
    
    public List<Voucher> getAllVoucher()
    {
        return voucherRepository.findAll();
    }

    public Optional<Voucher> getVoucherById(String voucherId) {
        return voucherRepository.findById(voucherId);
    }

    public Voucher createVoucher(Voucher voucher)
    {
        return voucherRepository.save(voucher);
    }
}
