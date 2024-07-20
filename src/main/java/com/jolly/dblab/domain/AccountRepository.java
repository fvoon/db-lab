package com.jolly.dblab.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, String> {
    default Account findByIdOrThrow(String id) {
        return findById(id).orElseThrow();
    }

    @Query("""
        select new com.jolly.dblab.domain.NamesView(a.firstName, a.lastName)
        from Account a
        where a.id = :id
        """)
    NamesView findNamesOnlyById(String id);

    @Query(value = """
        select first_name, last_name
        from account
        where id = :id
        """, nativeQuery = true)
    INamesView findINamesOnlyById(String id);

    AccountBankInfoView findAccountBankInfoById(String id);

    // dynamic projection
    <T> T findById(String id, Class<T> clazz);
}
