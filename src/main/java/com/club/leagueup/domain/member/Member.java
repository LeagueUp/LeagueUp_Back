package com.club.leagueup.domain.member;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long memberId;

    private String memberName;

    private String userFormId;

    private String password;

//    @ManyToOne
//    @JoinColumn(name = "CLUB_ID")
    private String club;

    private String sports;


}
