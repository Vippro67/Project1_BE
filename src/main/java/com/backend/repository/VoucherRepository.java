package com.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.entity.Voucher;

public interface VoucherRepository extends MongoRepository<Voucher, String> {


}