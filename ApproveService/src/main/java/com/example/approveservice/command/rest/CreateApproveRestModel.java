package com.example.approveservice.command.rest;

import lombok.Data;

@Data
public class CreateApproveRestModel {
    private String type;
    private String approveTargetId;
    private Boolean status;

    public CreateApproveRestModel() {}

    public CreateApproveRestModel(String type, String approveTargetId, Boolean status) {
        this.type = type;
        this.approveTargetId = approveTargetId;
        this.status = getStatus();
    }
}
