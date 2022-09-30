package com.yologger.spring_mongodb.data;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<MemberDocument, String> {
}
