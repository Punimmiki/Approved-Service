package com.example.approveservice.query;

import com.example.approveservice.core.data.ApproveEntity;
import com.example.approveservice.core.data.ApproveRepository;
import com.example.approveservice.core.data.ReportEntity;
import com.example.approveservice.core.data.ReportRepository;
import com.example.approveservice.core.events.ApproveCreateEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApproveEventsHandler {
    private final ApproveRepository approveRepository;
    private final ReportRepository reportRepository;


    @Autowired
    public ApproveEventsHandler(ApproveRepository approveRepository, ReportRepository reportRepository) {
        this.approveRepository = approveRepository;
        this.reportRepository = reportRepository;
    }

    @EventHandler
    public void on(ApproveCreateEvent event) {
        System.out.println(event);
//        switch (event.getType()) {
//            case "report":
//                ReportEntity report = reportRepository.findReportByReportId(event.getApproveTargetId());
//                if (report == null) {
//                    return;
//                }
//                System.out.println("Adding Approve in report => " + report);
//                ApproveEntity approveEntity = new ApproveEntity();
//                BeanUtils.copyProperties(event, approveEntity);
//                approveRepository.insert(approveEntity);
//                break;
//        }
        System.out.println("Adding Approve in report => ");
                ApproveEntity approveEntity = new ApproveEntity();
                BeanUtils.copyProperties(event, approveEntity);
                approveRepository.insert(approveEntity);
    }
}
