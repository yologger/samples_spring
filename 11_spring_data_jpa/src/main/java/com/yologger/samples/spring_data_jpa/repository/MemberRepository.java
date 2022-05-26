package com.yologger.samples.spring_data_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
