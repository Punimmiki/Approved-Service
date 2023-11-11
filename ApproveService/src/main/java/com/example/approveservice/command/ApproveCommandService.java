package com.example.approveservice.command;

import com.example.approveservice.command.rest.CreateApproveRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApproveCommandService {
    @Autowired
    private final CommandGateway commandGateway;

    @Autowired
    public ApproveCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RabbitListener(queues = "AddApproveQueue")
    public void createApprove(CreateApproveRestModel model) {
        System.out.println("ADD APPROVE");
        CreateApproveCommand command = CreateApproveCommand.builder()
                .approveId(UUID.randomUUID().toString())
                .type(model.getType())
                .approveTargetId(model.getApproveTargetId())
                .status(model.getStatus())
                .build();

        System.out.println(command);

        try {
            commandGateway.sendAndWait(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
