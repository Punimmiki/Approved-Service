package com.example.approveservice.command.rest;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApproveCommandController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping(value = "/approve/{type}/{approveTargetId}/{status}")
    public String createApprove(@PathVariable("type") String type, @PathVariable("approveTargetId") String approveTargetId, @PathVariable("status") Boolean status) {
        CreateApproveRestModel model = new CreateApproveRestModel();
        model.setType(type);
        model.setApproveTargetId(approveTargetId);
        model.setStatus(status);
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("application/json");
        Message message = rabbitTemplate.getMessageConverter().toMessage(model, messageProperties);
        rabbitTemplate.convertAndSend("ApproveExchange", "addApprove", message);
        return "Approve";
    }

}
