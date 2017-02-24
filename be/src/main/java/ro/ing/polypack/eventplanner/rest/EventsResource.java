package ro.ing.polypack.eventplanner.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.ing.polypack.eventplanner.entities.Event;

@RepositoryRestResource(collectionResourceRel = "events", path = "events")
public interface EventsResource extends PagingAndSortingRepository<Event, Long> {

}