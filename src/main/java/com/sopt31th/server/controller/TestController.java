package com.sopt31th.server.controller;

import com.sopt31th.server.common.dto.ApiResponse;
import com.sopt31th.server.common.exception.SuccessCode;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    @Value("${cloud.aws.credentials.access-key}")
    String test;
    @ApiOperation("컨트롤러 테스트 - Hello Spring 문자열을 출력합니다")
    @GetMapping("/v1/test")
    public ApiResponse<String> test() {
        System.out.println(test);
        return ApiResponse.success(SuccessCode.TEST_SUCCESS, "Hello Spring");
    }
}
