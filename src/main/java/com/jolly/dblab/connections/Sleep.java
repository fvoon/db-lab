package com.jolly.dblab.connections;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Sleep {

    @SneakyThrows
    static void sleep(long millis) {
        TimeUnit.MILLISECONDS.sleep(millis);
    }
}
