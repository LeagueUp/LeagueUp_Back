package com.club.leagueup.api.member.controller;

import com.club.leagueup.api.member.dto.MemberRequestDto;
import com.club.leagueup.api.member.dto.MemberResponseDto;
import com.club.leagueup.api.member.service.MemberService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @ApiOperation(value = "회원가입 API")
    public ResponseEntity<MemberResponseDto> saveMember(@RequestBody MemberRequestDto requestDto) {
        Long memberId = memberService.saveMember(requestDto);
        MemberResponseDto response= MemberResponseDto.builder()
                .memberId(memberId)
                .memberName(requestDto.getMemberName())
                .club(requestDto.getMemberClub())
                .sports(requestDto.getSports())
                .build();
        return ResponseEntity.ok(response);
    }

}
