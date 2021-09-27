package pl.matkac.tips.entities;

import com.sun.istack.NotNull;
import pl.matkac.tips.entities.enums.LeagueEnum;
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
public class League implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private LeagueEnum name;

    @ManyToMany
    @JoinTable(name = "user_league",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "league_id") })
    private Set<User> users;
}
