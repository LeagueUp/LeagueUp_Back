package com.club.leagueup.api.member.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {

    @ApiModelProperty(value = "유저 id")
    private String userFormId;

    @ApiModelProperty(value = "비밀번호")
    private String password;
}
