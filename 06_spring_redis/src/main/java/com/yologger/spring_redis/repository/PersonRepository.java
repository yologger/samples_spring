package com.yologger.spring_redis.repository;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    public Person findAllByEmail(String email);
}
