package com.backend.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.entity.Voucher;
import com.backend.repository.VoucherRepository;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;
    
    public List<Voucher> getAllVoucher(int page, int size)
    {
        Pageable pageable = org.springframework.data.domain.PageRequest.of(page - 1, size);
        Page<Voucher> voucherPage = voucherRepository.findAll(pageable);
        return voucherPage.getContent();
    }

    public Optional<Voucher> getVoucherById(String voucherId) {
        return voucherRepository.findById(voucherId);
    }

    public Voucher createVoucher(Voucher voucher)
    {
        return voucherRepository.save(voucher);
    }
}
