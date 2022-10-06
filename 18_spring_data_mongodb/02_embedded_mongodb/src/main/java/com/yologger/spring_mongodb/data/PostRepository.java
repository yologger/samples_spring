package com.yologger.spring_mongodb.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<PostDocument, String> {
}
