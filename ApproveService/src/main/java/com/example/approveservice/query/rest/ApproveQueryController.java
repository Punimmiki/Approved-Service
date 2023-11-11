package com.example.approveservice.query.rest;

import com.example.approveservice.query.FindApprovesQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/approves")
public class ApproveQueryController {
    private final QueryGateway queryGateway;

    public ApproveQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping()
    public List<ApproveRestModel> getApprove() {
        FindApprovesQuery findApprovesQuery = new FindApprovesQuery();
        return queryGateway.query(
                findApprovesQuery,
                ResponseTypes.multipleInstancesOf(ApproveRestModel.class)
        ).join();
    }
}
