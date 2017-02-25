package ro.ing.polypack.eventplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.ing.polypack.eventplanner.entities.Poll;

/**
 * Created by Antonel Ernest Pazargic on 24/02/2017.
 *
 * @author Antonel Ernest Pazargic
 */
public interface PollRepository extends JpaRepository<Poll, Long>, CustomPollRepository {

}
