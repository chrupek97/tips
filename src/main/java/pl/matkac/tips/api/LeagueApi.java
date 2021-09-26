package pl.matkac.tips.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.matkac.tips.entities.League;
import pl.matkac.tips.repo.LeagueRepo;

import java.util.List;

@RestController
@RequestMapping("/api/leagues")
@CrossOrigin(value = "origins = *", maxAge = 3600)
public class LeagueApi {

    @Autowired
    private LeagueRepo leagueRepo;

    @GetMapping
    public String hello(){
        return "hello";
    }

    @GetMapping("/{id}")
    public League getLeagueById(@PathVariable Long id){
        return leagueRepo.getById(id);
    }

    @GetMapping("/{id}/users")
    public List<String> getUsersByLeagueId(@PathVariable Long id){
        return leagueRepo.getUsersByLeagueId(id);
    }


}
