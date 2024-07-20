package com.jolly.dblab.domain;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface BankTransferRepository extends ListCrudRepository<BankTransfer, String> {
    default BankTransfer findByIdOrThrow(String id) {
        return findById(id).orElseThrow();
    }

    List<BankTransfer> findBySenderId(String senderId);
}
