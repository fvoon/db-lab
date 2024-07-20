package com.jolly.dblab.usecase;

import com.jolly.dblab.UseCaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@UseCaseTest
class SettleBankTransferUseCaseTest {
    @Autowired
    private SettleBankTransferUseCase useCase;

    @Test
    void execute() {
        useCase.execute("bank-transfer-id");
    }
}