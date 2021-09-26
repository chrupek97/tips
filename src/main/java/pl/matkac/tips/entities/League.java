package pl.matkac.tips.entities;

import com.fasterxml.jackson.annotation.JsonView;
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
    private LeagueEnum name;
    private int maxUsers;
    private int currentUsers;

    @ManyToMany(mappedBy = "leagues")
    private Set<User> users;
}
