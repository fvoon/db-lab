package com.jolly.dblab.usecase;

import com.jolly.dblab.domain.BankTransfer;
import com.jolly.dblab.domain.BankTransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenerateReportUseCase {
    private final BankTransferRepository bankTransferRepository;

    @Transactional
    public void execute(String senderId) {
        List<BankTransfer> entries = bankTransferRepository.findBySenderId(senderId);

        entries.stream()
                .peek(entry -> System.out.println(entry.getReceiver().getIban()));
    }
}
