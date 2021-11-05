package com.club.leagueup.api.member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel(value = "회원 정보", description = "회원 정보 객체")
public class MemberRequestDto {

    @ApiModelProperty(value="유저 이름")
    private String memberName;

    @ApiModelProperty(value="유저 아이디")
    private String userFormId;

    @ApiModelProperty(value="비밀번호")
    private String password;

    @ApiModelProperty(value="유저가 가입된 동호회 이름")
    private String memberClub;

    @ApiModelProperty(value="유저가 가입된 동호회의 스포츠 종목")
    private String sports;
}
