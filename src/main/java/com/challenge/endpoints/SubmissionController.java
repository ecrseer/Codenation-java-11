package com.challenge.endpoints;


import com.challenge.entity.Submission;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class SubmissionController {

    @Autowired private SubmissionService submissionService;

    @GetMapping
    public ResponseEntity<List<Submission>> findbyChallengeIdAndAccelerationId(
            @RequestParam Long challengeId,
            @RequestParam Long accelerationId){
        List<Submission> sbmssns = null;
        sbmssns=submissionService.findByChallengeIdAndAccelerationId(challengeId,accelerationId);
        return sbmssns.isEmpty()?
                ResponseEntity.notFound().build():ResponseEntity.ok(sbmssns);
    }

}
