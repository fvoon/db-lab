package com.jolly.dblab.connections;

import org.springframework.stereotype.Service;

@Service
public class ExternalService {

    public void externalCall() {
        Sleep.sleep(200);
    }
}
