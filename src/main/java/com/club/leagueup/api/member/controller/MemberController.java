package com.club.leagueup.api.member.controller;

import com.club.leagueup.api.member.dto.MemberRequestDto;
import com.club.leagueup.api.member.dto.MemberResponseDto;
import com.club.leagueup.api.member.service.MemberService;
import com.club.leagueup.config.JwtTokenProvider;
import com.club.leagueup.domain.member.Member;
import com.club.leagueup.domain.member.repository.MemberRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;

    @PostMapping("/join")
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


    @PostMapping("/login")
    @ApiOperation(value = "로그인 API")
    public String login(@RequestBody Map<String, String> user) {
        Member member = memberRepository.findByUserFormId(user.get("userFormId"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 아이디입니다."));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }
}
