package com.jolly.dblab.usecase;

import com.jolly.dblab.domain.AccountRepository;
import com.jolly.dblab.domain.NamesView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetAccountInfoUseCase {
    private final AccountRepository accountRepository;

    @Transactional
    public void getName(String accountId) {
        System.out.println(accountRepository.findNamesOnlyById(accountId).toFullName());
        System.out.println(accountRepository.findINamesOnlyById(accountId).toFullName());
    }

    @Transactional
    public void getBankInfo(String accountId) {
        System.out.println(accountRepository.findAccountBankInfoById(accountId));
    }

    @Transactional
    public void getNameDynamic(String accountId) {
        System.out.println(accountRepository.findById(accountId, NamesView.class));
    }
}
