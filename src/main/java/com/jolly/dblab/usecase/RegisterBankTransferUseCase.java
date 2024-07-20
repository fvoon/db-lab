package com.jolly.dblab.usecase;

import com.jolly.dblab.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterBankTransferUseCase {
    private final AccountRepository accountRepository;
    private final BankTransferRepository bankTransferRepository;

    public void execute(String bankTransferId, String reference, String senderId, String receiverId, Amount amount) {
        Account sender = accountRepository.findByIdOrThrow(senderId);
        Account receiver = accountRepository.findByIdOrThrow(receiverId);

        BankTransfer bankTransfer = BankTransfer.create(bankTransferId, reference, sender, receiver, amount);
        bankTransferRepository.save(bankTransfer);
    }
}
