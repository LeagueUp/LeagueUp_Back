package com.club.leagueup.domain;

import com.club.leagueup.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Club {

    @Id @GeneratedValue
    private Long id;

    private String club_name;

    private String region;

    private String sports;

    @OneToMany(mappedBy = "club")
    List<Member> members = new ArrayList<Member>();
}
