package com.jolly.dblab.usecase;

import com.jolly.dblab.UseCaseTest;
import com.jolly.dblab.domain.Amount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@UseCaseTest
class RegisterBankTransferUseCaseTest {
    @Autowired
    private RegisterBankTransferUseCase useCase;

    @Test
    void execute() {
        try {
            useCase.execute(UUID.randomUUID().toString(), "random reference", "sender-id", "receiver-id", Amount.of(10, "USD"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}