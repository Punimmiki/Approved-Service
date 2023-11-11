package com.example.approveservice.core.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends MongoRepository<ReportEntity, String> {
    @Query(value = "{ '_Id' : ?0 }")
    public ReportEntity findReportByReportId(String reportId);
}

