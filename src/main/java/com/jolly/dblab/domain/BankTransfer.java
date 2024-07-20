package com.jolly.dblab.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@DynamicUpdate
public class BankTransfer {
    @Id
    private String id;

    private String reference;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account sender;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account receiver;

    @Embedded
    private Amount amount;

    @Version
    private Long version;

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
                null,
                State.CREATED
        );
    }

    public void settle() {
        this.state = State.SETTLED;
    }
}
