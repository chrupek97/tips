package pl.matkac.tips.entities;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CustomLeague implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    private int maxUsers;
    private int currentUsers;

    @OneToMany
    @JoinColumn(name="custom_league_id")
    private Set<Tips> tipsSet;

    @OneToMany
    @JoinColumn(name="custom_league_id")
    private Set<UserCustomLeague> userCustomLeagueSet;

}
