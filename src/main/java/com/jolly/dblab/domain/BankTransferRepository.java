package com.jolly.dblab.domain;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BankTransferRepository extends JpaRepository<BankTransfer, String> {
    default BankTransfer findByIdOrThrow(String id) {
        return findById(id).orElseThrow();
    }

//    @Query("""
//        from BankTransfer b
//        join fetch b.sender
//        join fetch b.receiver
//        where b.sender.id = :senderId
//    """)
    @EntityGraph(attributePaths = {"sender", "receiver"}) //https://jpa-buddy.com/blog/dynamic-entity-graphs-in-spring-data-jpa/
    List<BankTransfer> findBySenderId(String senderId);
}
