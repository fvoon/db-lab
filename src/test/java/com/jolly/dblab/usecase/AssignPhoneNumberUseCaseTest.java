package com.jolly.dblab.usecase;

import com.jolly.dblab.UseCaseTest;
import com.jolly.dblab.domain.PhoneNumber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@UseCaseTest
class AssignPhoneNumberUseCaseTest {
    @Autowired
    private AssignPhoneNumberUseCase useCase;

    @Test
    void execute() {
        useCase.execute("sender-id", new PhoneNumber("11223344", PhoneNumber.Type.HOME));
    }
}