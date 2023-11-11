package com.example.approveservice.command;

import com.example.approveservice.core.events.ApproveCreateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ApproveAggregate {
    @AggregateIdentifier
    private String approveId;
    private String type;
    private String approveTargetId;
    private Boolean status;

    public ApproveAggregate() {}

    @CommandHandler
    public ApproveAggregate(CreateApproveCommand createApproveCommand) {
        System.out.println("ApproveAggregate Approve");
        ApproveCreateEvent approveCreateEvent = new ApproveCreateEvent();
        BeanUtils.copyProperties(createApproveCommand, approveCreateEvent);
        AggregateLifecycle.apply(approveCreateEvent);
    }

    @EventSourcingHandler
    public void on(ApproveCreateEvent approveCreateEvent) {
        System.out.println("EventSourcingHandler Approve");
        this.approveId = approveCreateEvent.getApproveId();
        this.type = approveCreateEvent.getType();
        this.approveTargetId = approveCreateEvent.getApproveTargetId();
        this.status = approveCreateEvent.getStatus();
    }
}
