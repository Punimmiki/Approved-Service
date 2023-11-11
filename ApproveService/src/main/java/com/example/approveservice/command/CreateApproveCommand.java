package com.example.approveservice.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.AggregateIdentifier;

@Builder
@Data
public class CreateApproveCommand {
    @AggregateIdentifier
    private final String approveId;
    private final String type;
    private final String approveTargetId;
    private final Boolean status;

}
