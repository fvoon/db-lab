package com.jolly.dblab;

import com.jolly.dblab.domain.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.HashSet;
import java.util.UUID;
import java.util.stream.IntStream;

@org.springframework.boot.test.context.TestConfiguration(proxyBeanMethods = false)
public class DbLabTestConfiguration {
    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgreSQLContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
                .withReuse(true);
    }

    @Bean
    ApplicationRunner applicationRunner(AccountRepository accountRepository, BankTransferRepository bankTransferRepository) {
        return args -> {
            Account sender = new Account("sender-id", "iban1", "John", "Smith", new HashSet<>());
            sender.addPhoneNumber(new PhoneNumber("111", PhoneNumber.Type.HOME));
            Account persistedSender = accountRepository.save(sender);
            Account receiver = accountRepository.save(new Account("receiver-id", "iban2", "Yusof", "Tayub", new HashSet<>()));

            bankTransferRepository.save(BankTransfer.create("bank-transfer-id", "reference2", persistedSender, receiver, Amount.of(100, "USD")));

//            IntStream.range(0, 50)
//                    .mapToObj(idx -> {
//                        Account account = accountRepository.save(new Account(UUID.randomUUID().toString(), "iban2", "Yusof", "Tayub", new HashSet<>()));
//                        BankTransfer bankTransfer = BankTransfer.create(UUID.randomUUID().toString(), "reference", persistedSender, account, Amount.of(100, "USD"));
//                        return bankTransferRepository.save(bankTransfer);
//                    });
            for (int i = 0; i < 50; i++) {
                Account account = accountRepository.save(new Account(
                        UUID.randomUUID().toString(), "iban2", "John", "Doe", new HashSet<>()));
                BankTransfer bankTransfer = BankTransfer.create(UUID.randomUUID().toString(), "reference", persistedSender,
                        account, Amount.of(100, "USD"));
                bankTransferRepository.save(bankTransfer);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.from(DbLabApplication::main)
                .with(DbLabTestConfiguration.class)
                .run(args);
    }
}
