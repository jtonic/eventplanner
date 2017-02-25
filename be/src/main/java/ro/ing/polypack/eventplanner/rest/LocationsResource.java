package ro.ing.polypack.eventplanner.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.ing.polypack.eventplanner.entities.EventLocation;
import ro.ing.polypack.eventplanner.entities.Poll;

@RepositoryRestResource(collectionResourceRel = "locations", path = "locations")
public interface LocationsResource extends PagingAndSortingRepository<EventLocation, Long> {

}