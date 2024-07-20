package com.jolly.dblab.usecase;

import com.jolly.dblab.domain.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.TransactionException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterBankTransferUseCase {
    private final AccountRepository accountRepository;
    private final BankTransferRepository bankTransferRepository;

    @Transactional
    public void execute(String bankTransferId, String reference, String senderId, String receiverId, Amount amount) throws TransactionException {
        // will throw EntityNotFoundException at insert if account does not exist
        // https://github.com/jakartaee/persistence/issues/206
        Account sender = accountRepository.getReferenceById(senderId);
        Account receiver = accountRepository.getReferenceById(receiverId);
        BankTransfer bankTransfer = BankTransfer.create(bankTransferId, reference, sender, receiver, amount);

        try {
            bankTransferRepository.saveAndFlush(bankTransfer);
        } catch (DataIntegrityViolationException e) {
            System.out.println(e);
        }
    }
}
