package com.jolly.dblab.domain;

// projection
public record NamesView(String firstName, String lastName) {
    public String toFullName() {
        return "%s %s".formatted(this.firstName(), this.lastName());
    }
};
