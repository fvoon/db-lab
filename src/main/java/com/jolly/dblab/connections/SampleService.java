package com.jolly.dblab.connections;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final AnotherService anotherService;
    private final PersonRepository personRepository;
    private final ExternalService externalService;
    private final TransactionTemplate transactionTemplate;

    @Transactional
    public void hello() {
        System.out.println(personRepository.findAll());
    }

    @Transactional
    public void withExternalServiceCall() {
        externalService.externalCall();
        System.out.println(personRepository.findAll());
    }

//    @Transactional
    public void  withExternalServiceCallAfter() {
        transactionTemplate.executeWithoutResult(transactionStatus -> {
            System.out.println(personRepository.findAll());
        });
        externalService.externalCall();
    }

//    @Transactional
    public void withNestedTransaction() {
        transactionTemplate.executeWithoutResult(transactionStatus -> {
            System.out.println(personRepository.findAll());
        });
        anotherService.runsInNewTransaction();
    }
}
