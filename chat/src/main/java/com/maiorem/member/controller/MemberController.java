package com.maiorem.member.controller;

import com.maiorem.member.domain.Member;
import com.maiorem.member.dto.*;
import com.maiorem.member.service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ApiOperation(value="회원 전체 조회", notes="현재 존재하는 회원 리스트를 가져온다")
    @GetMapping("/members")
    public Result memberV2() {
        List<Member> findMembers = memberService.findMembers();
        List<MemberDTO> collect = findMembers.stream()
                .map(m -> new MemberDTO(m.getName(), m.getEmail()))
                .collect(Collectors.toList());
        return new Result(collect.size(), collect);
    }

    @ApiOperation(value="신규 회원 가입", notes="new member create")
    @PostMapping("/members")
    public CreateMemberResponse saveMEmberV2(@RequestBody @Valid CreateMemberRequest request) {

        Member member = new Member();
        member.setName(request.getName());

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);

    }

    @ApiOperation(value="회원 정보 수정", notes="회원 정보 수정")
    @PutMapping("/members/{id}")
    public UpdateMemberResponse updateMemberV2(@PathVariable("id") Long id, @RequestBody @Valid UpdateMemberRequest request) {
        memberService.update(id, request.getName());
        Member findMember = memberService.findOne(id);
        return new UpdateMemberResponse(findMember.getMemberId(), findMember.getName());
    }

}
