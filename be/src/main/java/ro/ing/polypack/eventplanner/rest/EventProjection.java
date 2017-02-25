package ro.ing.polypack.eventplanner.rest;

import org.springframework.data.rest.core.config.Projection;
import ro.ing.polypack.eventplanner.entities.Event;
import ro.ing.polypack.eventplanner.entities.EventLocation;
import ro.ing.polypack.eventplanner.entities.Individual;

import java.util.List;

/**
 * Created by Antonel Ernest Pazargic on 25/02/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@Projection(name = "EventProjection", types = { Event.class })
public interface EventProjection {
    String getHost();
    String getTitle();
    String getDescription();
    List<Individual> getParticipants();
    EventLocation getLocation();
}
