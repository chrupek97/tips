package pl.matkac.tips.entities;

import pl.matkac.tips.entities.enums.RoleEnum;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String eMail;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @OneToMany
    @JoinColumn(name="user_id")
    private Set<Tips> tipsSet;

    @OneToMany
    @JoinColumn(name="user_id")
    private Set<UserCustomLeague> userCustomLeagueSet;
}
