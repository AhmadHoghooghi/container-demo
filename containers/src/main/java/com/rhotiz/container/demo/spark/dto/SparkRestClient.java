package com.rhotiz.container.demo.spark.dto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "spark-submit-client", url = "http://localhost:${spark-submit.rest.port}")
public interface SparkRestClient {

    @PostMapping(value = "/v1/submissions/create", consumes = "application/json;charset=UTF-8")
    CreateSubmissionResponseDto submitSparkJob(@RequestBody CreateSubmissionRequestDto requestInJson);


    @GetMapping(value = "v1/submissions/status/{submissionId}")
    SubmissionStatusResponseDto getJobStatus(@PathVariable String  submissionId);
}
