package pl.matkac.tips.entities;

import pl.matkac.tips.entities.enums.ResultEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    private int round;

    @ManyToOne
    private Team homeTeam;

    @ManyToOne
    private Team awayTeam;
    private LocalDateTime date;
    private int homeTeamGoals;
    private int awayTeamGoals;

    @OneToMany
    @JoinColumn(name="match_id")
    private Set<Tips> tipsSet;

    @Enumerated(EnumType.STRING)
    private ResultEnum result;
}
