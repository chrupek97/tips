package pl.matkac.tips.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.matkac.tips.entities.League;
import pl.matkac.tips.exceptions.ElementNotFoundException;
import pl.matkac.tips.repo.LeagueRepo;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/leagues")
@CrossOrigin(value = "origins = *", maxAge = 3600)
public class LeagueApi {

    @Autowired
    private LeagueRepo leagueRepo;

    @GetMapping("/{id}")
    public League getLeagueById(@PathVariable Long id) throws ElementNotFoundException {
        return leagueRepo.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("Not found league with id: "+ id));
    }

    @GetMapping("/{id}/users")
    public List<String> getUsersByLeagueId(@PathVariable Long id){
        return leagueRepo.getUsersByLeagueId(id);
    }

    @PostMapping
    public ResponseEntity<League> addLeague(@RequestBody League league) throws URISyntaxException {
        leagueRepo.save(league);

        return ResponseEntity
                .ok()
                .location(new URI("http://../api/league/"+league.getId()))
                .body(league);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<League> deleteLeague(@PathVariable Long id) throws ElementNotFoundException {
        leagueRepo.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("Not found league with id: "+ id));

        leagueRepo.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public League editLeague(@PathVariable Long id, @RequestBody League leagueDetails) throws ElementNotFoundException {
        League league = leagueRepo.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("Not found league with id: "+ id));

        league.setName(leagueDetails.getName());
        league.setUsers(leagueDetails.getUsers());

        return leagueRepo.save(league);
    }

}
