package com.club.leagueup.api.member.service;

import com.club.leagueup.api.member.dto.MemberRequestDto;
import com.club.leagueup.domain.member.Member;
import com.club.leagueup.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public Long saveMember(MemberRequestDto requestDto) {

        String password = passwordEncoder.encode(requestDto.getPassword());
        Member member = Member.builder()
                .memberName(requestDto.getMemberName())
                .userFormId(requestDto.getUserFormId())
                .password(password)
                .club(requestDto.getMemberClub())
                .sports(requestDto.getSports())
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .build();

        return memberRepository.save(member).getMemberId();
    }
}
