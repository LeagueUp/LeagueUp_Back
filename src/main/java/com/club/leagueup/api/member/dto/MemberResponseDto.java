package com.club.leagueup.api.member.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ApiModel(value = "회원가입 반환 객체", description = "회원가입 반환 객체")
public class MemberResponseDto {
    private Long memberId;
    private String memberName;
    private String club;
    private String sports;
}
