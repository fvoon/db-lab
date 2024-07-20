package com.jolly.dblab.connections;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleController {
    private final SampleService sampleService;
    private final ExternalService externalService;

    @GetMapping("/hello")
    void hello() {
        sampleService.hello();
        externalService.externalCall();
    }

    @GetMapping("/external")
    void external() {
        sampleService.withExternalServiceCall();
    }

    @GetMapping("/external-after")
    void externalAfter() {
        sampleService.withExternalServiceCallAfter();
    }

    @GetMapping("/nested")
    void nested() {
        sampleService.withNestedTransaction();
    }
}
