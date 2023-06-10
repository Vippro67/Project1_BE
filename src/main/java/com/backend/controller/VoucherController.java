package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.Voucher;
import com.backend.service.VoucherService;

@RestController
@RequestMapping("api/v1//voucher")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;
    @GetMapping()
    public List<Voucher> getAllTours()
    {
        return voucherService.getAllVoucher();
    }
    
    @PostMapping
    public Voucher createVoucher(@RequestBody Voucher voucher) {
        return voucherService.createVoucher(voucher);
    }
}
