package ro.ing.polypack.eventplanner.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.ing.polypack.eventplanner.model.RatingDto;
import ro.ing.polypack.eventplanner.repositories.PollRepository;

/**
 * Created by Antonel Ernest Pazargic on 25/02/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PollController {

    private PollRepository pollRepository;

    @Autowired
    public void config(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @PutMapping("/rating")
    public void rating(@RequestBody RatingDto rating) {
        this.pollRepository.saveRating(rating.getPollId(), rating.getYes());
    }

}
