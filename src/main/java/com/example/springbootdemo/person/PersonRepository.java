package com.example.springbootdemo.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// <Type, IdType>
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT s FROM Person s WHERE s.email = ?1")
    Optional<Person> findPersonByEmail(String email);

}
