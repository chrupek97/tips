package pl.matkac.tips.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.matkac.tips.entities.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueRepo extends JpaRepository<League, Long> {

    @Query(value = "SELECT USER.LOGIN\n" +
            "FROM USER_LEAGUES, USER\n" +
            "WHERE USER_LEAGUES.LEAGUES_ID =:id AND USER_LEAGUES.USERS_ID = USER.ID", nativeQuery = true)
    public List<String> getUsersByLeagueId(@Param("id") Long id);
}
