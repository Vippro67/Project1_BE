package com.backend.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.entity.Voucher;
import com.backend.repository.BookingRepository;
import com.backend.repository.VoucherRepository;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private BookingRepository bookingRepository;
    
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

    public Voucher updateVoucher(String id, Voucher voucher) {
        Voucher voucherToUpdate = voucherRepository.findById(id).get();
        voucherToUpdate.setNumber(voucher.getNumber());
        voucherToUpdate.setValue(voucher.getValue());
        voucherToUpdate.setStart(voucher.getStart());
        voucherToUpdate.setEnd(voucher.getEnd());
        return voucherRepository.save(voucherToUpdate);
    }

    public String deleteVoucher(String id) {

        // Check if voucher exists in booking
        if(bookingRepository.findByVoucherId(id).size() > 0)
            throw new RuntimeException("Voucher is in use");

        voucherRepository.deleteById(id);
        return "Voucher with id " + id + " has been deleted!";
    }
}
