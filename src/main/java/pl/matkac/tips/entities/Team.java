package pl.matkac.tips.entities;

import pl.matkac.tips.entities.enums.LeagueEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    private String name;
    private LeagueEnum league;

    @OneToMany(mappedBy = "homeTeam")
    private Set<Match> matchesHome;

    @OneToMany(mappedBy = "awayTeam")
    private Set<Match> matchesAway;
}
