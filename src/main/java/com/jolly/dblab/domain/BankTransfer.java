package com.jolly.dblab.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BankTransfer {
    @Id
    @UuidGenerator
    private String id;

    private String reference;

    @ManyToOne
    private Account sender;

    @ManyToOne
    private Account receiver;

    @Embedded
    private Amount amount;

    @Enumerated(EnumType.STRING)
    private State state;

    public enum State {
        CREATED, SETTLED,
        ;
    }

    public static BankTransfer create(String id, String reference, Account sender, Account receiver, Amount amount) {
        return new BankTransfer(
                id,
                reference,
                sender,
                receiver,
                amount,
                State.CREATED
        );
    }

    public void settle() {
        this.state = State.SETTLED;
    }
}
