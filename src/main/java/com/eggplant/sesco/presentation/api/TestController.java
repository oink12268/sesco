package com.eggplant.sesco.presentation.api;

import com.eggplant.sesco.application.admin.TestService;
import com.eggplant.sesco.presentation.config.security.UserDetailsVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
@RestController
public class TestController {

    private final TestService testService;

    @GetMapping("/permit-all")
    public Object getTest() throws Exception {
        return testService.getTest();
    }

    @Secured("ROLE_AUTH")
    @GetMapping("/auth")
    public Object getTest2(@AuthenticationPrincipal UserDetailsVo securityUser) throws Exception {
        return testService.getTest2();
    }

}
