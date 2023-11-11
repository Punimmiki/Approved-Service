package com.example.approveservice.core.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("Report")
public class ReportEntity implements Serializable {
    @Id
    private String reportId;
    private String type;
    private String reportTargetId;

    public ReportEntity() {}

    public ReportEntity(String reportId, String type, String reportTargetId) {
        this.reportId = reportId;
        this.type = type;
        this.reportTargetId = reportTargetId;
    }
}
