package com.jolly.dblab.usecase;

import com.jolly.dblab.UseCaseTest;
import com.jolly.dblab.domain.PhoneNumber;
import org.junit.jupiter.api.Test;
import org.quickperf.sql.annotation.ExpectDelete;
import org.quickperf.sql.annotation.ExpectSelect;
import org.quickperf.sql.annotation.ExpectUpdate;
import org.springframework.beans.factory.annotation.Autowired;

@UseCaseTest
class AssignPhoneNumberUseCaseTest {
    @Autowired
    private AssignPhoneNumberUseCase useCase;

    @Test
//    @ExpectSelect(1)
//    @ExpectUpdate(1)
//    @ExpectDelete(0)
    void execute() {
        useCase.execute("sender-id", new PhoneNumber("11223344", PhoneNumber.Type.HOME));
    }
}