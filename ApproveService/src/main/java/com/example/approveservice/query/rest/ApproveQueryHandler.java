package com.example.approveservice.query.rest;

import com.example.approveservice.core.data.ApproveEntity;
import com.example.approveservice.core.data.ApproveRepository;
import com.example.approveservice.query.FindApprovesQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApproveQueryHandler {
    private final ApproveRepository approveRepository;

    public ApproveQueryHandler(ApproveRepository approveRepository) {
        this.approveRepository = approveRepository;
    }

    @QueryHandler
    public List<ApproveRestModel> findApproves(FindApprovesQuery query) {
        List<ApproveRestModel> approveRest = new ArrayList<>();
        List<ApproveEntity> storedApproves = approveRepository.findAll();
        for (ApproveEntity approveEntity : storedApproves) {
            ApproveRestModel approveRestModel = new ApproveRestModel();
            BeanUtils.copyProperties(approveEntity, approveRestModel);
            approveRest.add(approveRestModel);
        }
        return approveRest;
    }
}
