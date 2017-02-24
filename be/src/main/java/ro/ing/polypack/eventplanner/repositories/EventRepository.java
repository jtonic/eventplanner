package ro.ing.polypack.eventplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ing.polypack.eventplanner.entities.Event;

/**
 * Created by Antonel Ernest Pazargic on 24/02/2017.
 *
 * @author Antonel Ernest Pazargic
 */
public interface EventRepository extends JpaRepository<Event, Long> {

}
