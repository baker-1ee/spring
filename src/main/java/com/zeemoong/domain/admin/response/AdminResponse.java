package com.zeemoong.domain.admin.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminResponse {

    private String name;

    private String email;
}
