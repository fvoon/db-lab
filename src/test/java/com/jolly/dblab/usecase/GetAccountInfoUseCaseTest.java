package com.jolly.dblab.usecase;

import com.jolly.dblab.UseCaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@UseCaseTest
class GetAccountInfoUseCaseTest {
    @Autowired
    private GetAccountInfoUseCase useCase;

    @Test
    void getName() {
        useCase.getName("sender-id");
    }

    @Test
    void getBankInfo() {
        useCase.getBankInfo("sender-id");
    }

    @Test
    void getNameDynamic() {
        useCase.getNameDynamic("sender-id");
    }
}