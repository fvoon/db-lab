package com.jolly.dblab.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Account {
    @Id
    private String id;

    private String iban;

    private String firstName;
    private String lastName;

    @ElementCollection
    @CollectionTable(
            name = "phone_number",
            joinColumns = @JoinColumn(name = "account_id")
    )
    private Set<PhoneNumber> phoneNumbers = new HashSet<>();

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }

    public Account setId(String id) {
        this.id = id;
        return this;
    }

    public Account setIban(String iban) {
        this.iban = iban;
        return this;
    }

    public Account setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Account setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
