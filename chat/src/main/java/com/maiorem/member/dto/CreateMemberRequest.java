package com.maiorem.member.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateMemberRequest {
    //외부 api 스펙을 엔티티보단 여기서 변경하는게 안전함
    @NotEmpty
    private String name;
}
