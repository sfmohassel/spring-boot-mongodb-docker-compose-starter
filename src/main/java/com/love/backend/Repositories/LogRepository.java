package com.love.backend.Repositories;

import com.love.backend.Entities.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {
}
