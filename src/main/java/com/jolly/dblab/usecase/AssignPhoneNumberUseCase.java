package com.jolly.dblab.usecase;

import com.jolly.dblab.domain.Account;
import com.jolly.dblab.domain.AccountRepository;
import com.jolly.dblab.domain.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AssignPhoneNumberUseCase {
    private final AccountRepository accountRepository;

    @Transactional
    public void execute(String accountId, PhoneNumber phoneNumber) {
        Account account = accountRepository.findByIdOrThrow(accountId);
        account.addPhoneNumber(phoneNumber);
        accountRepository.save(account);
    }
}
