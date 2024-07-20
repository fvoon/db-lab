package com.jolly.dblab.usecase;

import com.jolly.dblab.domain.BankTransfer;
import com.jolly.dblab.domain.BankTransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SettleBankTransferUseCase {
    private final BankTransferRepository bankTransferRepository;

    @Transactional
    public void execute(String bankTransferId) {
        BankTransfer bankTransfer = bankTransferRepository.findByIdOrThrow(bankTransferId);
        bankTransfer.settle();
        bankTransferRepository.save(bankTransfer);
    }
}
