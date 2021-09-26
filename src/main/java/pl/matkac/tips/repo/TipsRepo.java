package pl.matkac.tips.repo;

import pl.matkac.tips.entities.Tips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipsRepo extends JpaRepository<Tips, Long> {
}
