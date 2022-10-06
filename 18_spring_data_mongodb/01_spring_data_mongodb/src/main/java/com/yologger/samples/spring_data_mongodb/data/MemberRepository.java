package com.yologger.samples.spring_data_mongodb.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<MemberDocument, String> {
}
