package com.example.approveservice.core.events;

import lombok.Data;

@Data
public class ApproveCreateEvent {
    private String approveId;
    private String type;
    private String approveTargetId;
    private Boolean status;
}
