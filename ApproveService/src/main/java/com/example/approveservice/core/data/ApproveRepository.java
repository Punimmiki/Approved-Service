package com.example.approveservice.core.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApproveRepository extends MongoRepository<ApproveEntity, String> {
    @Query(value = "{ 'approveId' : ?0 }")
    public ApproveEntity findApproveByApproveId(String approveId);
}
