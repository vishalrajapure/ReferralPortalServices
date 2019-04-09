package com.vaibhav.minion.referralportal.controller;

import com.vaibhav.minion.referralportal.model.*;
import com.vaibhav.minion.referralportal.service.EmployeeService;
import com.vaibhav.minion.referralportal.service.HMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rp")
public class ReferralPortalController {

    @Autowired
    private HMService hmService;

    @Autowired
    private EmployeeService employeeService;

    /*********************************************_HM_***********************************************************/

    @PostMapping(value = "/hm/insertJob", consumes = "application/json", produces = "application/json")
    public ResponseEntity<InsertJobResponse> insertJob(@RequestBody InsertJobRequest insertJobRequest) {
        InsertJobResponse insertJobResponse = hmService.insertJob(insertJobRequest);
        return ResponseEntity.ok().body(insertJobResponse);
    }

    @GetMapping(value = "/hm/getOpenJob", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<JOBS>> getOpenJobs(@RequestParam("employeeId") String employeeId) {
        List<JOBS> openJobsList = hmService.getOpenJobs(employeeId);
        return ResponseEntity.ok().body(openJobsList);
    }

    @GetMapping(value = "/hm/getReferrals", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<REFERRALS>> getReferrals(@RequestParam("jobId") Double jobId) {
        List<REFERRALS> referralsList = hmService.getReferralsFromJobId(jobId);
        return ResponseEntity.ok().body(referralsList);
    }

//    @PostMapping(value = "/hm/updateJobStatus", consumes = "application/json", produces = "application/json")


//    TODO: 1.UPDATE JOB STATUS 2.UPDATE REFERRAL STATUS 3.REASON WHILE UPDATING

    /*********************************************_EMPLOYEE_***********************************************************/

    @GetMapping(value = "/employee/getOpenJob", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<JOBS>> getOpenAllJobs() {
        List<JOBS> openJobsList = employeeService.getAllOpenJobs();
        return ResponseEntity.ok().body(openJobsList);
    }

    @PostMapping(value = "/employee/addReferral", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AddReferralResponse> addReferal(@RequestBody AddReferralRequest addReferralRequest) {
        AddReferralResponse referralResponse = employeeService.addReferral(addReferralRequest);
        return ResponseEntity.ok().body(referralResponse);
    }

    @GetMapping(value = "/employee/getReferralsByEmployeeId", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<REFERRALS>> getReferrals(@RequestParam("employeeId") String employeeId) {
        List<REFERRALS> employeeList = employeeService.getReferralsOfEmployeeId(employeeId);
        return ResponseEntity.ok().body(employeeList);
    }

    /*********************************************_HR_***********************************************************/

    /*********************************************_ADMIN_***********************************************************/

}
