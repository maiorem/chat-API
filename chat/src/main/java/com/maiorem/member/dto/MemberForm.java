package com.maiorem.member.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수입니다.")
    private String name;
}
