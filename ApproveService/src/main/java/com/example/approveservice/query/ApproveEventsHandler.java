package com.example.approveservice.query;

import com.example.approveservice.core.data.*;
import com.example.approveservice.core.events.ApproveCreateEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApproveEventsHandler {
    private final ApproveRepository approveRepository;
    private final ReportRepository reportRepository;

    private final UserRepository userRepository;


    @Autowired
    public ApproveEventsHandler(ApproveRepository approveRepository, ReportRepository reportRepository, UserRepository userRepository) {
        this.approveRepository = approveRepository;
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
    }

    @EventHandler
    public void on(ApproveCreateEvent event) {
        System.out.println(event);
        switch (event.getType()) {
            case "report":
                ReportEntity report = reportRepository.findReportByReportId(event.getApproveTargetId());
                if (report == null) {
                    return;
                }
                System.out.println("Adding Approve in report => " + report);
                ApproveEntity reportApproveEntity = new ApproveEntity();
                BeanUtils.copyProperties(event, reportApproveEntity);
                approveRepository.insert(reportApproveEntity);
                break;

            case "writer":
                UserEntity user = userRepository.findUserByUserId(event.getApproveTargetId());
                if (user == null) {
                    return;
                }
                System.out.println("Adding Approve in writer => " + user);
                ApproveEntity writerapproveEntity = new ApproveEntity();
                BeanUtils.copyProperties(event, writerapproveEntity);
                approveRepository.insert(writerapproveEntity);
                break;

        }


    }
}
