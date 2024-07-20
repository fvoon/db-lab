package com.jolly.dblab.connections;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnotherService {
    private final PersonRepository personRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void runsInNewTransaction() {
        System.out.println(personRepository.findAll());
        Sleep.sleep(400);
    }
}
