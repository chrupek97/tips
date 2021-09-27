package pl.matkac.tips.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/leagues")
@CrossOrigin(value = "origins = *", maxAge = 3600)
public class MatchApi {
}
