package com.example.approveservice.query.rest;

import lombok.Data;

@Data
public class ApproveRestModel {

    private  String approveId;
    private  String type;
    private  String approveTargetId;
    private Boolean status;

}
