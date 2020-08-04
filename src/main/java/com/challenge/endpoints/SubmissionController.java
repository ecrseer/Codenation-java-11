package com.challenge.endpoints;


import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;

import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class SubmissionController {

    @Autowired private SubmissionService submissionService;

    @Autowired private SubmissionMapper submissionMapper;



    @GetMapping
    public ResponseEntity<List<SubmissionDTO>> findbyChallengeIdAndAccelerationId(
            @RequestParam(required = true,name = "challengeId") Long challengeId,
            @RequestParam (required = true,name="accelerationId")Long accelerationId){

        List<Submission> sbmssns = null;
        sbmssns=submissionService.findByChallengeIdAndAccelerationId(challengeId,accelerationId);


        return sbmssns.isEmpty()?
                ResponseEntity.notFound().build():
                ResponseEntity.ok(submissionMapper.map(sbmssns));
    }

}
