package com.jolly.dblab.domain;

public interface INamesView {
    String getFirstName();
    String getLastName();

    default String toFullName() {
        return "%s %s".formatted(getFirstName(), getLastName());
    }
}
