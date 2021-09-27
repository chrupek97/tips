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
    private String name;
    private String surname;
    private String eMail;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;
}
