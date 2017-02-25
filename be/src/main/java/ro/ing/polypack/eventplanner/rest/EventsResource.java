package ro.ing.polypack.eventplanner.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import ro.ing.polypack.eventplanner.entities.Event;

@RepositoryRestResource(collectionResourceRel = "events", path = "events", excerptProjection = EventProjection.class)
@CrossOrigin(origins = "http://localhost:8080")
public interface EventsResource extends JpaRepository<Event, Long> {

}