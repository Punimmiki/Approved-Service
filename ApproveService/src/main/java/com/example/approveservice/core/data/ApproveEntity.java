package com.example.approveservice.core.data;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Approve")
public class ApproveEntity {
    @Id
    private String approveId;
    private String type;
    private String approveTargetId;
    private Boolean status;

    public ApproveEntity() {}

    public ApproveEntity(String approveId, String type, String approveTargetId, Boolean status) {
        this.approveId = approveId;
        this.type = type;
        this.approveTargetId = approveTargetId;
        this.status = status;
    }
}
