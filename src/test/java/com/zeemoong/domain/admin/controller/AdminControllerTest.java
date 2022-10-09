package com.zeemoong.domain.admin.controller;

import com.zeemoong.domain.admin.response.AdminResponse;
import com.zeemoong.domain.admin.service.AdminService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {

    @InjectMocks
    private AdminController adminController;

    @Mock
    private AdminService adminService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAdminTest() {
        // given
        String name = "이한슬";
        String email = "sky@naver.com";

        AdminResponse adminResponse = AdminResponse.builder().name(name).email(email).build();
        BDDMockito.given(adminService.getAdmin()).willReturn(adminResponse);

        // when
        ResponseEntity<AdminResponse> responseEntity = adminController.getAdmin();

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(Objects.requireNonNull(responseEntity.getBody()).getName()).isEqualTo(name);
        assertThat(Objects.requireNonNull(responseEntity.getBody()).getEmail()).isEqualTo(email);
    }

    @Test
    void loggingInterceptor_가_정상_등록되어있다면_response_body_를_콘솔에_출력해준다() throws Exception {
        // given
        String name = "이한슬";
        String email = "sky@naver.com";

        AdminResponse adminResponse = AdminResponse.builder().name(name).email(email).build();
        BDDMockito.given(adminService.getAdmin()).willReturn(adminResponse);

        // when
        ResultActions resultActions = mockMvc.perform(get("/admin")
                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpect(status().isOk()).andDo(print());
    }

}